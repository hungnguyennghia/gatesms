
package vc.process;

import java.util.ArrayList;
import java.util.UUID;

import vc.VCSMS;
import vc.database.DBTool;
import vc.util.StringTool;
import vc.util.beanBR;

public class SendSMSFromDB
{


    public static void SendSMSFromDB()
    {
    	DBTool db =new DBTool();
		ArrayList beans=db.getAllSMSFromDB();
		for (int i = 0; i < beans.size(); i++) {
			beanBR bean= (beanBR)beans.get(i);
	            bean.setRequest_id(UUID.randomUUID().toString());
	            bean.setBrandname("FPTShop");
	            bean.setAccount("auto");        
	            bean.buildMobileOperator();
	            bean.setSmsCount(1);
	            if(bean.getInfo().length()>160){
	                try {
	        			String[] splittedMsg = StringTool.SplitByWidth(bean.getInfo(), 153);
	        			int totalSMS = splittedMsg.length;
	        			bean.setSmsCount(totalSMS);
	        		} catch (Exception e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		}
	            }
	                bean.setMessageid("0");
	            VCSMS.getRequestBRQueue().enqueue(bean);
	        	VCSMS.getLogFileQueue().enqueue(bean);
	        	VCSMS.getLogDBQueue().enqueue(bean);
	        	
		}
    }



}
