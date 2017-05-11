// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PLoggerDB.java

package vc.util.logger;

import vc.VCSMS;
import vc.database.*;
import vc.util.beanBR;

// Referenced classes of package vc.util.logger:
//            FileLogger

public class PLoggerDB extends Thread
{

    public PLoggerDB()
    {
        dbTool = null;
        fileLogger = null;
        dbTool = new DBTool();
        fileLogger = new FileLogger();
    }

    public void run()
    {
        
        while(VCSMS.isRunning()){
        	beanBR mo=null;
            try
            {
                mo = (beanBR)VCSMS.getLogDBQueue().dequeue();
                System.out.println((new StringBuilder("[PLoggerDB]")).append(mo.getPhone_number()).toString());
                boolean add2MOlogResult = false;
                if(DBPool.isConnecting())
                    add2MOlogResult = dbTool.insert2BR(mo);
                if(!add2MOlogResult)
                    fileLogger.logMO_ERR(mo);
            	try {
    				sleep(10);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
            catch(DBException ex)
            {
                System.out.println((new StringBuilder("[PLoggerDB]")).append(ex.getMessage()).toString());
                fileLogger.logMO_ERR(mo);
            }
        	try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    }


    private DBTool dbTool;
    private FileLogger fileLogger;
}
