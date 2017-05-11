package vc.process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;
import vc.VCSMS;

public class CallUrl extends Thread
{
	private static int curentDateOld=0;
	private static String formatDate="dd/MM/yyyy";
	private static String formatTime="HHmmss";
	
	private static int startTime=0;
	private static int endTime=0;
	private static String srcUrl="";
	private static String desPath="";
	private static List<String> process = new ArrayList<String>(); 
    public CallUrl()
    {
    	loadURLConfig();
    }

    public void sendGet(String url) {
    try  {
                System.out.println(url);
            String jsonData = "";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
                // optional default is GET
                con.setRequestMethod("GET");
        
                //add request header
              //  con.setRequestProperty("User-Agent", USER_AGENT);
        
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
        
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
        
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    jsonData+= inputLine + "\n";
                }
                in.close();
        
            JSONObject obj1 = new JSONObject(jsonData);
            for (int i = 1; i < obj1.length(); i++) {
				System.out.println(i+": " + obj1.getString(i+""));
			}
            

    } catch (Exception ex)  {
        ex.printStackTrace();
    } finally  {
    }
 
    
    }
	private static void loadURLConfig() {
		process.clear();
		BufferedReader fin = null;
					 try {
						 String CMC_File ="./conf/minhngoc.conf";
						 System.out.println("load file:"+CMC_File);
			            fin = new BufferedReader(new FileReader(CMC_File));						
						String line = null;
						while ( (line = fin.readLine()) != null) {					
							process.add(line);
						}
						
						fin.close();
						 
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					 
        
		}
    public void run()
    {
    	while(VCSMS.isRunning()){
    		try {
    			Long curTimeInMinute = new Long( System.currentTimeMillis());
    			Timestamp genDate= new Timestamp(curTimeInMinute.longValue());
    			Timestamp genDate1= new Timestamp(1413341682);
    			
    			
    			int gio=Integer.parseInt(Timestamp2HHMMSS(genDate));
    			String ngayHT = Timestamp2DDMMYYYY(genDate,formatDate);
    			int curentDate = Integer.parseInt(Timestamp2DDMMYYYY(genDate,"yyyyMMdd"));
    			//insertDB("MB",ngayHT,1,"123456");
				for (int i = 0; i < process.size(); i++) {
	    			startTime=0;
	    			endTime=0;
	    			srcUrl="";
	    			desPath="";
					String[] temp=process.get(i).split(";");
	    			startTime=Integer.parseInt(temp[0]);
	    			endTime=Integer.parseInt(temp[1]);
	    			srcUrl=temp[2];
	    			desPath=temp[3];

	    			if((gio>startTime)&&(gio<endTime)){
		    			System.out.println("Hom nay la ngay:"+ngayHT+"--"+gio);
		    			
	    			}
				}
    			String url="http://www.ketqua888.com/jsonup/live_MB.json";
    			sendGet(url);
    			sleep(1000);
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
    public static String addDay(java.sql.Timestamp ts,int addday) {
    	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatDate);
    	Calendar c1 = Calendar.getInstance(); 
    	c1.setTime(new java.util.Date(ts.getTime()));
    	c1.add(c1.DATE, addday);
    	return sdf.format(c1.getTime());
}      

public static String Timestamp2DDMMYYYY(java.sql.Timestamp ts,String formatD) {
    	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatD);
    	Calendar c1 = Calendar.getInstance(); 
    	c1.setTime(new java.util.Date(ts.getTime()));
    	return sdf.format(c1.getTime());
}      
public static String Timestamp2HHMMSS(java.sql.Timestamp ts) {
    	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatTime);
    	Calendar c1 = Calendar.getInstance(); 
    	c1.setTime(new java.util.Date(ts.getTime()));
    	return sdf.format(c1.getTime());
} 
 

}
