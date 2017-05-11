package vc.util.logger;

import java.io.*;
import sms.util.DateProc;
import sms.util.Today;
import vc.common.LoggerConfig;
import vc.util.beanBR;

public class FileLogger
{

    public FileLogger()
    {
        File dir = new File(LoggerConfig.MO_LOG_FOLDER);
        if(!dir.exists())
            dir.mkdir();
        dir = new File(LoggerConfig.MO_ERR_LOG_FOLDER);
        if(!dir.exists())
            dir.mkdir();
    }

    public void logMO_ERR(beanBR moData)
    {
        String mo_err_log_folder = LoggerConfig.MO_ERR_LOG_FOLDER;
        File dir = new File(mo_err_log_folder);
        if(!dir.exists())
            dir.mkdir();
        mo_err_log_filename = "logDB.err";
        try
        {
            PrintWriter fout = new PrintWriter(new FileWriter((new StringBuilder(String.valueOf(mo_err_log_folder))).append("/").append(mo_err_log_filename).toString(), true));
            fout.print((new StringBuilder(String.valueOf(moData.getAccount()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getRequest_id()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getBrandname()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getPhone_number()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getCommand_code()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getInfo().replace("\n", "##")))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getRout()))).append("|").toString());
            fout.print(DateProc.getYYYYMMDDHHMMSSString(DateProc.createTimestamp()));
            fout.println();
            fout.flush();
            fout.close();
        }
        catch(IOException ex)
        {
            System.out.println((new StringBuilder("FileLogger.logMO_ERR: path file --> ")).append(mo_err_log_folder).append("/").append(mo_err_log_filename).append(" with ex: ").append(ex.getMessage()).toString());
        }
    }

    public void logMO(beanBR moData)
    {
        Today today = Today.getInstance();
        String mo_log_folder = LoggerConfig.MO_LOG_FOLDER;
        File dir = new File(mo_log_folder);
        if(!dir.exists())
            dir.mkdir();
        mo_log_filename = (new StringBuilder(String.valueOf(today.getYYYY_MM_DD()))).append(".mo").toString();
        try
        {
            PrintWriter fout = new PrintWriter(new FileWriter((new StringBuilder(String.valueOf(mo_log_folder))).append("/").append(mo_log_filename).toString(), true));
            fout.print((new StringBuilder(String.valueOf(moData.getAccount()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getRequest_id()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getBrandname()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getPhone_number()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getCommand_code()))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getInfo().replace("\n", "##")))).append("|").toString());
            fout.print((new StringBuilder(String.valueOf(moData.getRout()))).append("|").toString());
            fout.print(DateProc.getYYYYMMDDHHMMSSString(DateProc.createTimestamp()));
            fout.println();
            fout.flush();
            fout.close();
        }
        catch(IOException ex)
        {
            System.out.println((new StringBuilder("FileLogger.logMO: ")).append(ex.getMessage()).toString());
        }
    }

    private static String mo_err_log_filename = "";
    private static String mo_log_filename = "";
    private static int mt_log_counter = 0;
    private static String mt_err_log_filename = "";
    private static String mt_log_filename = "";

}
