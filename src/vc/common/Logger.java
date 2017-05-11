package vc.common;


import java.util.*;
import java.sql.*;
import java.io.*;


import sms.pdu.Deliver;
import sms.pdu.PDUException;
import sms.pdu.Submit;
import sms.util.*;
import sms.util.Queue;


public class Logger extends Thread {
    static final int LOG_TO_CONSOLE = 0;
    static final int LOG_TYPE_INFO  = 1;
    static final int LOG_TYPE_ALERT = 2;
    static final int LOG_TYPE_ERROR = 3;
    static final int LOG_TYPE_PDU   = 4;
    public void logCommand(String cmd, String user)
    {
        if(cmd == null)
        {
            return;
        } else
        {
            Today today = Today.getInstance();
            today.getH24_MI_SEC();
            String msg = today.getYYYY_MM_DD() + " " + today.getH24_MI_SEC() + "  [" + user + "] " + cmd + "\r\n";
            String filename = LoggerConfig.LOG_TO_FOLDER + "/cmd-" + today.getYYYY_MM_DD() + ".log";
            FileTool.saveToFile(msg.getBytes(), filename, true);
            return;
        }
    }
    //String objects which are waiting to be logged
    //Log into console, file, or telnet sessions
    private static Queue logQueue = null;
    private static boolean networkLogEnabled = false;
	public static boolean isNetworkLogEnabled() {
		return networkLogEnabled;
	}
	public static void setNetworkLogEnabled(boolean value) {
		networkLogEnabled = value;
	}
    static {
        File dir = new File(LoggerConfig.LOG_TO_FOLDER);
        if (!dir.exists()) {
            dir.mkdir();
        }
        logQueue = new Queue();
        new LogThread(logQueue).start(); //Start Logger when the class is loaded
    }
    public static void load() {}

    private String source = "";
    public Logger(String source) {
        this.source = source;
    }
  
 
    
    //print info message
    public void info(String msg) {
        logQueue.enqueue(new LogMessage(msg, this.source, Logger.LOG_TYPE_INFO));
    }

    //print error message
    public void error(String msg) {
        this.logQueue.enqueue(new LogMessage(msg, this.source, Logger.LOG_TYPE_ERROR));
    }

    //print error message
    public void alert(String msg) {
        this.logQueue.enqueue(new LogMessage(msg, this.source, Logger.LOG_TYPE_ALERT));
    }

    /* Log to console if enabled */
    public void log2C(String msg) {
        this.logQueue.enqueue(new LogMessage(msg, this.source, Logger.LOG_TO_CONSOLE));
        /*
        if (GatewayConfig.LOG_TO_CONSOLE == 1 && !KeyboardReader.isReadingInput()) {
            System.out.println(msg);
        }
       */
    }

    public void logConnectionStateChanged(String msg) {
        if (msg == null) return;
        Today today = Today.getInstance();
        today.getH24_MI_SEC();
        msg = today.getYYYY_MM_DD() + " " + today.getH24_MI_SEC() + "  [" + this.source + "] " + msg + "\r\n";
        String filename = LoggerConfig.LOG_TO_FOLDER + "/conn-" + today.getYYYY_MM_DD() + ".log";
        FileTool.saveToFile(msg.getBytes(), filename, true);
    }

  


}

class LogThread extends Thread {
    private static PrintWriter openedLogFile = null;
    private static String logFilename = null; //yyyy-mm-dd.log
    private static PrintWriter openedErrorFile = null;
    private static String errorFilename = null; //yyyy-mm-dd.err
    private Queue logQueue = null;

    LogThread (Queue queue) {
        this.logQueue = queue;
    }

    public void run() {
        //System.out.println("LogThread is started.");
        LogMessage logMessage = null;
        String logText = null;
        while (true) {
            try {
                logMessage = (LogMessage) logQueue.dequeue();

                if (logMessage == null) continue;

                //Log to all telnet sessions if debug is ON
                switch (logMessage.getType()) {
                    case Logger.LOG_TO_CONSOLE:
                        break;
                    case Logger.LOG_TYPE_INFO:
                        logText = "[I] " + "[" + logMessage.getSource() + "] " + logMessage.getText();
                        this.add2LogFile(logText);
                        break;
                    case Logger.LOG_TYPE_PDU:
                        logText = "[P] " + "[" + logMessage.getSource() + "] " + logMessage.getText();
                        this.add2LogFile(logText);
                        break;
                    case Logger.LOG_TYPE_ALERT:
                        logText = "[A] " + "[" + logMessage.getSource() + "] " + logMessage.getText();
                        this.add2ErrorFile(logText);
                        break;
                    case Logger.LOG_TYPE_ERROR:
                        logText = "[E] " + "[" + logMessage.getSource() + "] " + logMessage.getText();
                        this.add2ErrorFile(logText);
                        break;
                    default:
                        //do nothing
                }
            } catch (Exception ex) {
                System.out.println("LogThread.run: " + ex.getMessage());
            }
        }
    }

    private void add2LogFile(String logText) {
        if (LoggerConfig.LOG_TO_FILE != 1) {
            return;
        }

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentDate = DateProc.Timestamp2YYYYMMDD(ts, "-");
        String currentTime = DateProc.Timestamp2HHMMSS(ts, 0);

        if (openedLogFile == null || logFilename == null ||
            !logFilename.startsWith(currentDate)) {
            logFilename = currentDate + ".log";
            openLogFile(); //open a new file
        }
        openedLogFile.println("[" + currentDate + " " + currentTime + "] " + logText);
        openedLogFile.flush();
    }

    private void add2ErrorFile(String logText) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentDate = DateProc.Timestamp2YYYYMMDD(ts, "-");
        String currentTime = DateProc.Timestamp2HHMMSS(ts, 0);
        if (openedErrorFile == null || errorFilename == null ||
            !errorFilename.startsWith(currentDate)) {
            errorFilename = currentDate + ".err";
            openErrorFile(); //open a new file
        }
        openedErrorFile.println("[" + currentDate + " " + currentTime + "] " + logText);
        openedErrorFile.flush();
    }

    private static Vector liveAdminSessions = null;
  


    private void openLogFile() {
        try {
            openedLogFile = new PrintWriter(new BufferedWriter(
                new FileWriter(LoggerConfig.LOG_TO_FOLDER + "/" + logFilename, true))); // append=true
        } catch (IOException ex) {
            System.out.println("Logger.openLogFile: " + ex.getMessage());
        }
    }
    private void openErrorFile() {
        try {
            openedErrorFile = new PrintWriter(new BufferedWriter(
                new FileWriter(LoggerConfig.LOG_TO_FOLDER + "/" + errorFilename, true))); // append=true
        } catch (IOException ex) {
            System.out.println("Logger.openErrorFile: " + ex.getMessage());
        }
    }
}

class LogMessage {
    private String text;
    private int type; //1-INFO, 2-ALERT, 3-ERROR, 4-PDU
    private String source;

    public LogMessage(String text, String source, int type) {
        this.text = text;
        this.source = source;
        this.type = type;
    }
    public String toString() {
        return "LogMessage: " + getSource() + " - " + getText() + " - " + getType();
    }

    void setText(String value) {
        this.text = value;
    }
    String getText() {
        return this.text;
    }
    void setSource(String value) {
        this.source = value;
    }
    String getSource() {
        return this.source;
    }

    void setType(int value) {
        this.type = value;
    }
    int getType() {
        return this.type;
    }

    public static void load() {};
    private static Queue logQueue;
}
