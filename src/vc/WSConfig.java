// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WSConfig.java

package vc;

import java.io.*;
import java.util.*;

// Referenced classes of package vc:
//            APIBR

public class WSConfig
{

    public WSConfig()
    {

		
    }



    public static void loadPropertiesConfig()
        throws IOException
    {
        FileInputStream propsFile = new FileInputStream((new StringBuilder(String.valueOf(dirFileLog))).append("conf/wsconfig.properties").toString());
        properties.load(propsFile);
        propsFile.close();
        dirLog = properties.getProperty("dirLog", dirLog);
        dirFileLog = properties.getProperty("dirFileLog", dirFileLog);
        fileNameMT = properties.getProperty("fileNameMT", fileNameMT);
        urlSOS=properties.getProperty("urlSOS", urlSOS);
        checksend=getIntProperty("checksend", checksend);
        infobipUser=properties.getProperty("infobipUser", infobipUser);
        infobipPass=properties.getProperty("infobipPass", infobipPass);
        vhtUser=properties.getProperty("vhtUser", vhtUser);
        vhtPass=properties.getProperty("vhtPass", vhtPass);
    }

    public static void initLoadProperties()
    {
        try
        {
            allowIPs = loadAllowIPProperties();
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Can not find config-file '")).append(allowIPsDir).append("'").toString());
            e.printStackTrace();
        }
        try
        {
            allowUsers = loadAllowUserProperties();
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Can not find config-file '")).append(allowUsersDir).append("'").toString());
            e.printStackTrace();
        }
        dir = new File(dirLog);
        if(!dir.exists())
            dir.mkdir();
    }

    private static Hashtable loadAllowIPProperties()
        throws Exception
    {
        Hashtable proHashTable = null;
        FileInputStream in = new FileInputStream((new StringBuilder(String.valueOf(dirFileLog))).append("conf/allowIPs.properties").toString());
        if(proHashTable == null)
            proHashTable = new Hashtable();
        else
            proHashTable.clear();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        for(String temp = reader.readLine(); temp != null; temp = reader.readLine())
            if(!temp.equals(""))
            {
                String tk;
                for(StringTokenizer token = new StringTokenizer(temp, ","); token.hasMoreTokens(); proHashTable.put(tk, "allow"))
                {
                    tk = token.nextToken();
                    tk = tk.trim();
                }

            }

        return proHashTable;
    }

    private static Hashtable loadAllowUserProperties()
        throws Exception
    {
        Hashtable proHashTable = null;
        FileInputStream in = new FileInputStream((new StringBuilder(String.valueOf(dirFileLog))).append("conf/allowUsers.properties").toString());
        if(proHashTable == null)
            proHashTable = new Hashtable();
        else
            proHashTable.clear();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        for(String temp = reader.readLine(); temp != null; temp = reader.readLine())
            if(!temp.equals(""))
            {
                String inLine[] = temp.split(",");
                System.out.println((new StringBuilder(String.valueOf(inLine[0]))).append(",").append(inLine[1]).toString());
                proHashTable.put(inLine[0], inLine[1]);
            }

        return proHashTable;
    }
	static int getIntProperty(String propName, int defaultValue)
	{
		return Integer.parseInt(properties.getProperty(propName, Integer.toString(defaultValue)).trim());
	}

    public static Hashtable allowIPs = new Hashtable();
    public static Hashtable allowUsers = new Hashtable();
    static String allowIPsDir = "./conf/allowIPs.properties";
    static String allowUsersDir = "./conf/allowUsers.properties";
    public static String dirLog = (new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("/LOG").toString();
    public static String dirFileLog = "";
    public static String fileNameMT = (new StringBuilder(String.valueOf(System.getProperty("user.dir")))).append("/LOG").toString();
    public static String urlSOS="";
    static Properties properties = new Properties();
    static File dir = null;
    public static int checksend=0;
    public static String infobipUser="FRTECOM";
    public static String infobipPass="24Honline@123!";
    public static String vhtUser="fptshop";
    public static String vhtPass="*$#@FPTShopHCM@*(*";
}
