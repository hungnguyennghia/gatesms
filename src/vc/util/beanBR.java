
package vc.util;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import vc.util.SMSTool;
import vc.util.StringTool;

public class beanBR
{

    public beanBR()
    {
        account = "";
        phone_number = "";
        command_code = "";
        info = "";
        date_time = "";
        rout = 0;
    }


    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }

    public void setPhone_number(String phone_number)
    {
        this.phone_number = phone_number;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public void setCommand_code(String command_code)
    {
        this.command_code = command_code;
    }

    public String getCommand_code()
    {
        return command_code;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }


    public void setDate_time(String date_time)
    {
        this.date_time = date_time;
    }

    public String getDate_time()
    {
        return date_time;
    }

    public void toFile(PrintWriter fout)
        throws IOException
    {
        String line = (new StringBuilder(String.valueOf(getAccount())))
        		.append("|").append(getRequest_id()).append("|")
        		.append(getBrandname()).append("|")
        		.append(getPhone_number()).append("|")
        		.append(getCommand_code()).append("|")
        		.append(getInfo()).append("|")
        		.append(getRout()).toString();
        fout.println(line);
        fout.flush();
    }

    public static beanBR parseString(String line)
    {
        if(line == null)
            return null;
        Collection c = StringTool.parseString(line, "|");
        if(c.size() < 7)
        {
            System.out.println((new StringBuilder("Invalid MO String: ")).append(line).toString());
            return null;
        } else
        {
            Iterator it = c.iterator();
            beanBR mo = new beanBR();
            mo.setAccount((String)it.next());
            mo.setRequest_id((String)it.next());            
            mo.setBrandname((String)it.next());
            mo.setPhone_number((String)it.next());
            mo.setCommand_code((String)it.next());
            mo.setInfo((String)it.next());
            mo.setRout(Integer.parseInt((String)it.next()));
            return mo;
        }
    }

    public int getRout()
    {
        return rout;
    }

    public void setRout(int rout)
    {
        this.rout = rout;
    }
    public String getRequest_id() {
		return request_id;
	}


	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getMobileOperator() {
		return mobileOperator;
	}


	public void setMobileOperator(String mobileOperator) {
		this.mobileOperator = mobileOperator;
	}
	
    public void buildMobileOperator()
    {
        String temp = phone_number;
        String result = null;

        result = SMSTool.buildMobileOperator(temp);
        mobileOperator = result;
    }
	public int getSmsCount() {
		return smsCount;
	}


	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}
	public String getMessageid() {
		return messageid;
	}


	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getBrandname() {
		return brandname;
	}


	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getTime_send() {
		return time_send;
	}


	public void setTime_send(String time_send) {
		this.time_send = time_send;
	}

	private String request_id;
    private String account;
    private String command_code;//dinh danh tu dich vu
    private String phone_number;
    private String brandname;
    private String info;
    private String date_time;
    private String time_send;
    private int rout;
    private String mobileOperator;
    private int smsCount;
    private String messageid;
}
