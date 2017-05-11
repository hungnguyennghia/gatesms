
package vc.process;

import vc.VCSMS;
import vc.WSConfig;


public class loadConfig extends Thread
{

    public loadConfig()
    {
    }

    public void run()
    {
    	 while(VCSMS.isRunning()){
             try
             {
                 WSConfig.loadPropertiesConfig();
             }
             catch(Exception e)
             {
                 System.out.println("khong doc duoc file ./conf/loadPropertiesConfig.properties");
             }
          //   detextAcc.setAccountsFile();
             try {
				sleep(30000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    	 }
    }
}
