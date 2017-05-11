package ws.sendSMS;

import java.io.File;
import java.util.Hashtable;
import java.util.Properties;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import vc.util.StringTool;
import vc.VCSMS;
import vc.WSConfig;
import vc.database.DBException;
import vc.database.DBTool;
import vc.util.Queue;
import vc.util.beanBR;




/**
 *
 * @author hungnn
 */
@WebService(name = "sendSMS", targetNamespace = "http://sendSOS.vc/")
public class RSendSMS {

 
    public RSendSMS() {      
            requestBRQueue = VCSMS.getRequestBRQueue();
            logFileQueue = VCSMS.getLogFileQueue();
            logDBQueue = VCSMS.getLogDBQueue();
            allowUsers = WSConfig.allowUsers;
            dirLog = WSConfig.dirLog;
    }  

    
    @WebMethod(operationName = "sendSMS")
    public String sendSMS(
    		@WebParam(name = "source", targetNamespace = "http://sendSOS.vc/") String source,
            @WebParam(name = "phone_number", targetNamespace = "http://sendSOS.vc/") String phone_number,
            @WebParam(name = "info", targetNamespace = "http://sendSOS.vc/") String info,
            @WebParam(name = "userName", targetNamespace = "http://sendSOS.vc/") String userName,
            @WebParam(name = "passWord", targetNamespace = "http://sendSOS.vc/") String passWord
            ) {
        System.out.println("Starting sendSMS .... ");
        String result = "-1";

    	try {
            beanBR bean = new beanBR();
            bean.setRequest_id(UUID.randomUUID().toString());
            bean.setPhone_number(phone_number);
            bean.setCommand_code(source);//phan biet tu nguon nao gui
            bean.setBrandname("FPTShop");
            bean.setInfo(info);
            bean.setAccount((new StringBuilder(String.valueOf(userName))).append("/").append(passWord).toString());        
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

            boolean checkUser = authenUser(userName, passWord);
            if(!checkUser)
            {
            	bean.setMessageid("-2");
                System.out.println(" -- Deny User -- ");
            } else
            {
            	result=bean.getRequest_id();
                bean.setMessageid("0");
                VCSMS.getRequestBRQueue().enqueue(bean);
            }
        	VCSMS.getLogFileQueue().enqueue(bean);
        	VCSMS.getLogDBQueue().enqueue(bean);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" -- loi khong xac dinh -- ");
		}

        return result;
            
    }
 

    @WebMethod(operationName = "checkStatus")
    public String checkStatus(
            @WebParam(name = "request_id", targetNamespace = "http://sendSOS.vc/") String request_id,
            @WebParam(name = "userName", targetNamespace = "http://sendSOS.vc/") String userName,
            @WebParam(name = "passWord", targetNamespace = "http://sendSOS.vc/") String passWord
            ) {

        System.out.println("Starting checkStatus .... ");
        String result = "-1";

        boolean checkUser = authenUser(userName, passWord);
        if(!checkUser)
        {
            System.out.println(" -- Deny User -- ");
            result = "-3";
            return result;
        }
        DBTool dbTool = new DBTool();
        try
        {
            result = dbTool.getStatusBR_ByID(request_id);
        }
        catch(DBException e)
        {
            e.printStackTrace();
            result = "-1";
        }
        return result;
    }
   
   

    private static boolean authenUser(String user, String pass)
    {
        boolean result = false;
        if(allowUsers == null || allowUsers.size() == 0)
            return true;
        if(user == null || pass == null)
            return false;
        if(!allowUsers.containsKey(user))
        {
            System.out.println((new StringBuilder("There is no user name : ")).append(user).toString());
            result = false;
        } else
        if(!((String)allowUsers.get(user)).equals(pass))
        {
            System.out.println((new StringBuilder("Password doesn't match for user: ")).append(user).toString());
            result = false;
        } else
        {
            System.out.println((new StringBuilder(" Accepted user: ")).append(user).toString());
            result = true;
        }
        return result;
    }
    
   

    static String state = null;
    static Hashtable allowUsers = new Hashtable();
    static String receiver = null;
    static File dir = null;
    static final String _PREFIX = "\n";
    static String allowIPsDir = "./conf/allowIPs.properties";
    static String allowUsersDir = "./conf/allowUsers.properties";
    static String dirLog = (new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("/LOG").toString();
    static Properties properties = new Properties();
    static boolean wscpStatus = false;
    private Queue requestBRQueue;
    private Queue logFileQueue;
    private Queue logDBQueue;
}
