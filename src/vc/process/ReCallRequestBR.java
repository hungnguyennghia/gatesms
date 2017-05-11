
package vc.process;

import vc.VCSMS;
import vc.WSConfig;
import vc.util.beanBR;

public class ReCallRequestBR extends Thread
{

    public ReCallRequestBR()
    {

    }

    private void processRequest(beanBR bean)
    {
        String result = "-2";
        if(bean.getRout()==0){
            result = RequestBR.sendSMSToInfobip(bean);
        }else{
            result = RequestBR.sendSMSToVHT(bean);
        }
        
        if(Integer.parseInt(result)<0)
        {
        	bean.setRout(bean.getRout()==0?1:0);//neu gui infobip ko dc thi chuyen sang VHT
        	VCSMS.getRecallRequestBRQueue().enqueue(bean);
        }else{        	
            bean.setMessageid(result);//trang thai thanh cong
            VCSMS.getLogDBUpdateQueue().enqueue(bean);

        }
    }

    public void run()
    {
    	while(VCSMS.isRunning()){
    		try {
        		beanBR bean = (beanBR)VCSMS.getRecallRequestBRQueue().dequeue();
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
    		//sleep recall
			try {
				sleep(60*1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}

    }



}
