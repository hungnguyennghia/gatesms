
package vc.process;

import vc.VCSMS;
import vc.database.DBTool;
import vc.util.beanBR;

public class UpdateDB extends Thread
{

    public UpdateDB()
    {

    }

    private void processRequest(beanBR bean)
    {
    	try {
            DBTool db =new DBTool();
            boolean result=db.update2BR(bean);
            if(!result){
            	VCSMS.getLogDBQueue().enqueue(bean);
//            	VCSMS.getLogDBUpdateQueue().enqueue(bean);
            }

		} catch (Exception e) {
			// TODO: handle exception
			VCSMS.getLogDBUpdateQueue().enqueue(bean);
		}

  
    }

    public void run()
    {
    	while(VCSMS.isRunning()){
    		try {
        		beanBR bean = (beanBR)VCSMS.getLogDBUpdateQueue().dequeue();
        		if(!bean.getRequest_id().equals("")){
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
				sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}

    }



}
