
package vc.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
import com.tuankiet.brandname.ws.core.SmsPortType;
import vc.VCSMS;
import vc.WSConfig;
import vc.util.beanBR;

public class RequestBR extends Thread
{

    public RequestBR()
    {

    }

    private void processRequest(beanBR bean)
    {
    	bean.setRout(WSConfig.checksend);
    	if(bean.getPhone_number().startsWith("0")){
    		bean.setPhone_number("84"+bean.getPhone_number().substring(1));
    	}
    	if(!bean.getMobileOperator().equals("UNKNOWN")){
            String result = "-2";
            if(WSConfig.checksend==0){
                result = sendSMSToInfobip(bean);
            }else{
                result = sendSMSToVHT(bean);
            }
            
            
            if(Integer.parseInt(result)<0)
            {
            	bean.setRout(bean.getRout()==0?1:0);
            	VCSMS.getRecallRequestBRQueue().enqueue(bean);
            }else{
            	//update status send sms
            	bean.setRout(WSConfig.checksend);
                bean.setMessageid(result);
                VCSMS.getLogDBUpdateQueue().enqueue(bean);

            }
    	}else{
        	bean.setRout(WSConfig.checksend);
            bean.setMessageid("-1"); // khong phan biet duoc so dien thoai
            VCSMS.getLogDBUpdateQueue().enqueue(bean);
    	}

    }

    public void run()
    {
    	while(VCSMS.isRunning()){
    		try {
        		beanBR bean = (beanBR)VCSMS.getRequestBRQueue().dequeue();
        		if(!bean.getPhone_number().equals("")){
                    processRequest(bean);
        		}else{
        			sleep(100);
        		}
				
			} catch (Exception e) {
				// TODO: handle exception
				try {
					sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    	}

    }

    public static String sendSMSToInfobip(beanBR bean)
    {
        String re_sult = "-2";
        try {
	       String url = "http://api.infobip.com/api/v3/sendsms/json";
	
	        HttpClient client = new DefaultHttpClient();
	        HttpPost post = new HttpPost(url);
	
	        // add header
	//        post.setHeader("User-Agent", USER_AGENT);
	
	        JSONObject authentication =new JSONObject();
	        authentication.put("username",WSConfig.infobipUser);
	        authentication.put("password",WSConfig.infobipPass);
	        
	        JSONObject gsm =new JSONObject();
	        gsm.put("gsm",bean.getPhone_number());
	      
	
	        JSONArray recipients =new JSONArray();
	        recipients.put(gsm);
	        
	        JSONObject messages =new JSONObject();
	        messages.put("sender",bean.getBrandname());
	        if(bean.getSmsCount()>1)messages.put("type","longSMS");
	        messages.put("text",bean.getInfo());
	        messages.put("recipients",recipients);
	        
	        JSONObject json =new JSONObject();
	        json.put("authentication",authentication);
	        json.put("messages",messages);
	
	        System.out.println(json.toString());
	      //  { “authentication”: {  “username”: “test”,  “password”: “test” }, “messages”: [  {   “sender”: “Sender”,   “text”: “Hello”,   “recipients”: [    {     “gsm”: “385951111111”    }   ]  } ] }
	
	    StringEntity entity = new StringEntity(json.toString(), HTTP.UTF_8);
	    entity.setContentType("application/json");
	    post.setEntity(entity);
	                     
	
	        HttpResponse response = client.execute(post);
	
	        BufferedReader rd = new BufferedReader(
	                new InputStreamReader(response.getEntity().getContent()));
	
	        StringBuffer result = new StringBuffer();
	        String line = "";
	        while ((line = rd.readLine()) != null) {
	                result.append(line);
	        }
	
	        System.out.println(result.toString());
	 
	        JSONObject obj1 = new JSONObject(result.toString());
	        JSONArray jsonChannel =obj1.getJSONArray("results");
	        System.out.println(jsonChannel.getJSONObject(0).get("status"));
	        System.out.println(jsonChannel.getJSONObject(0).get("messageid"));
	        System.out.println(jsonChannel.getJSONObject(0).get("destination"));
	        if(jsonChannel.getJSONObject(0).get("status").toString().equals("0")){
	        	re_sult=jsonChannel.getJSONObject(0).get("messageid").toString();
	        }else{
	        	re_sult=jsonChannel.getJSONObject(0).get("status").toString();
	        }
	        
	        
	        //status=0 successful ; -13 incorrect number formatting ; -1 Invalid username and/or password;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return re_sult;
    }

    public static String sendSMSToVHT(beanBR bean)
    {
        String result = "-2";

        try {
           	URL url;
    		try {
 			
    			url = new URL("http://bc.vht.com.vn:8440/vht/services/sms?wsdl");
    	        QName qname = new QName("http://core.ws.brandname.tuankiet.com", "sms");
    	        Service service = Service.create(url, qname);
    	        SmsPortType hello = service.getPort(SmsPortType.class);
    	   		int kq=hello.sendSms(WSConfig.vhtPass,WSConfig.vhtUser,  bean.getPhone_number(), "FPTShop", bean.getInfo());
    	   		result=kq+"";
    		} catch (MalformedURLException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			System.out.println("[RequestSendMe]"+ e.getMessage());
    			VCSMS.getRequestBRQueue().enqueue(bean);
    		} catch (Exception e) {
    			System.out.println("[RequestSendMe]"+ e.getMessage());
    			VCSMS.getRequestBRQueue().enqueue(bean);
    			
    		}
    		

  	    } catch (Exception e) {
  	      e.printStackTrace();
  	    }
        return result;
    }
}
