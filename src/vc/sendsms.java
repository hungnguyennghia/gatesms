
package vc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Iterator;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tuankiet.brandname.ws.core.SmsPortType;

public class sendsms {
	private static final String USER_AGENT = "Mozilla/5.0";
    public static void main(String args[])throws Exception{

//     
//        Base64.Encoder enc= Base64.getEncoder();
//
//        byte[] authenticationenc =enc.encode(String.valueOf("Aladdin:open sesame").getBytes("US-ASCII"));
//
//        // add header
//        String authHeader = "Basic " + new String(authenticationenc);
//System.out.println(authHeader);
    	sendPost1SMS();
    //	createKeyScenarios();
//    	{"default":true,"name":"My VIBER-SMS scenario","flow":[{"channel":"VIBER","from":"ViberSender"}]}
//    	{"key":"2F89A7FC4ABBA56D48834242681BC137","name":"My VIBER-SMS scenario","flow":[{"from":"ViberSender","channel":"VIBER"}],"default":true}

    //	sendViber();
//           	URL url;
//    		try {
//    			url = new URL("http://bc.vht.com.vn:8440/vht/services/sms?wsdl");
//    	        QName qname = new QName("http://core.ws.brandname.tuankiet.com", "sms");
//    	        Service service = Service.create(url, qname);
//    	        SmsPortType hello = service.getPort(SmsPortType.class);
//    	   		int tt=hello.sendSms("*$#@FPTShopHCM@*(*", "fptshop", "0906289289", "FPTShop", "hungnn test vht");
//    		System.out.println(tt);
//    		} catch (MalformedURLException e) {
//    			// TODO Auto-generated catch block
//    			//e.printStackTrace();
//    			System.out.println("[RequestSendMe]"+ e.getMessage());
//    			
//    		} catch (Exception e) {
//    			System.out.println("[RequestSendMe]"+ e.getMessage());
//    			
//    			
//    		}
    		
        }
    private static void sendViber() throws Exception {
    try {
	       String url = "http://api.infobip.com/omni/1/advanced";
	
	        HttpClient client = new DefaultHttpClient();
	        HttpPost post = new HttpPost(url);
	
	        
//	        String auth=new StringBuffer("FRTECOM1").append(":").append("FPT$hop@!@#").toString();
//	        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//	        String authHeader = "Basic " + new String(encodedAuth);
//	        post.setHeader("AUTHORIZATION", authHeader);


	        Base64.Encoder enc= Base64.getEncoder();

	        byte[] authenticationenc =enc.encode(String.valueOf("FPTViber:Fptshop2017").getBytes("UTF-8"));

	        // add header
	        String authHeader = "Basic " + new String(authenticationenc);
	        post.setHeader("Authorization", authHeader);
	        
System.out.println(new String(authenticationenc));
	        JSONObject phoneNumber =new JSONObject();
	        phoneNumber.put("phoneNumber","84906289289");

	        JSONObject to =new JSONObject();
	        to.put("to",phoneNumber);

	        
	        JSONArray destinations =new JSONArray();
	        destinations.put(to);
	        
	        JSONObject viber =new JSONObject();
	        viber.put("text","ĐẶT TRƯỚC F3 PLUS NHẬN NGAY BỘ QUÀ KÉP");
	        viber.put("imageURL","https://fptshop.com.vn/OPPO-F3-Plus/Content/images/OPPO-F3-Plus.png");
	        viber.put("buttonText", "XEM THÊM");
	        viber.put("buttonURL","https://fptshop.com.vn/oppo-f3-plus");
	        viber.put("isPromotional",true);
	        viber.put("validityPeriod",1);
	        
	        JSONObject json =new JSONObject();
	        String key=createKeyScenarios();//UUID.randomUUID().toString();
	        json.put("scenarioKey",key);
	        json.put("destinations",destinations);
	        json.put("viber",viber);
	
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

//	        {
//	        	  "key": "CC9F01A5DC7BEE2C2B829D203482A654",
//	        	  "name":"My VIBER-SMS scenario",
//	        	  "flow": [
//	        	    {
//	        	      "from": "ViberSender",
//	        	      "channel": "VIBER"
//	        	    },
//	        	    {
//	        	      "from": "InfoSMS",
//	        	      "channel": "SMS"
//	        	    }    
//	        	  ],
//	        	  "default": true
//	        	}
//	        JSONObject obj1 = new JSONObject(result.toString());
//	        JSONArray jsonChannel =obj1.getJSONArray("results");
//	        System.out.println(jsonChannel.getJSONObject(0).get("status"));
//	        System.out.println(jsonChannel.getJSONObject(0).get("messageid"));
//	        System.out.println(jsonChannel.getJSONObject(0).get("destination"));
//	        if(jsonChannel.getJSONObject(0).get("status").toString().equals("0")){
//	        	re_sult=jsonChannel.getJSONObject(0).get("messageid").toString();
//	        }else{
//	        	re_sult=jsonChannel.getJSONObject(0).get("status").toString();
//	        }
	        
	        
	        //status=0 successful ; -13 incorrect number formatting ; -1 Invalid username and/or password;
		} catch (Exception e) {
			// TODO: handle exception
		}
}
    private static String createKeyScenarios () throws Exception {
    	String ressult="";
        try {
    	       String url = "http://api.infobip.com/omni/1/scenarios";
    	
    	        HttpClient client = new DefaultHttpClient();
    	        HttpPost post = new HttpPost(url);
    	
    	        
    	        Base64.Encoder enc= Base64.getEncoder();

    	        byte[] authenticationenc =enc.encode(String.valueOf("FPTViber:Fptshop2017").getBytes("UTF-8"));

    	        // add header
    	        String authHeader = "Basic " + new String(authenticationenc);
    	        post.setHeader("Authorization", authHeader);
    	        

    	        JSONObject flow =new JSONObject();
    	        flow.put("from","FPT Shop");
    	        flow.put("channel","VIBER");

    	        
    	        JSONArray flows =new JSONArray();
    	        flows.put(flow);
    	        

    	        
    	        JSONObject json =new JSONObject();
      	        json.put("name","My VIBER scenario");
    	        json.put("flow",flows);
    	        json.put("default",true);
    	
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
     	        System.out.println(obj1.getJSONObject("key"));
    	        ressult=obj1.getJSONObject("key").toString();

    	        
    	        //status=0 successful ; -13 incorrect number formatting ; -1 Invalid username and/or password;
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
        return ressult;
    }
    private static void sendPost1SMS() throws Exception {
        
        String url = "http://api.infobip.com/api/v3/sendsms/json";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        JSONObject authentication =new JSONObject();
        authentication.put("username","FRTECOM1");
        authentication.put("password","FPT$hop@!@#");
        
        JSONObject gsm =new JSONObject();
        gsm.put("gsm","84962590546");
      

        JSONArray recipients =new JSONArray();
        recipients.put(gsm);
        
        JSONObject messages =new JSONObject();
        messages.put("sender","FPTShop");
  //      messages.put("text","test infobip ok!");
        messages.put("type","longSMS");
        messages.put("text","Cam on anh/chi Ninh van kien da mua hang theo chinh sach uu dai F.Friends tai FPTShop.   Anh/chi duoc doi may moi trong 30N neu loi NSX. Neu co gi khong hai long, lien he 18006616 (mien phi). Xin cam on anh/chi!");

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
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " + 
                            response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
                result.append(line);
        }

        System.out.println(result.toString());
        
      //----------------------------------  
//        JSONObject results =new JSONObject();
//        results.put("status","0");
//        results.put("messageid","216032207051532806");
//        results.put("destination","84906289289");
//        
//        JSONArray recipients =new JSONArray();
//        recipients.put(results);
//        JSONObject results1 =new JSONObject();
//        results1.put("results", recipients);
//        System.out.println(results1.toString());
        JSONObject obj1 = new JSONObject(result.toString());
        JSONArray jsonChannel =obj1.getJSONArray("results");
        System.out.println(jsonChannel.getJSONObject(0).get("status"));
        System.out.println(jsonChannel.getJSONObject(0).get("messageid"));
        System.out.println(jsonChannel.getJSONObject(0).get("destination"));
//        JSONObject obj1 = new JSONObject();
       // {"results": [{"status":"0","messageid":"216032207051532806","destination":"84906289289"}]}

//        Iterator x = jsonChannel.keys();
//        
//        while (x.hasNext()){
//            String key = (String) x.next();
//            System.out.println("domain:"+key);
//           // System.out.println("data: " + jsonChannel.get(key));
//            
//            JSONObject objDoamin = new JSONObject(jsonChannel.get(key).toString());
//      // System.out.println("data: " + objDoamin.toString());
//            System.out.println("data: " + objDoamin.getString("response.bytes.content"));
//        }
}
    
}
