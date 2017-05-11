
package vc.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import vc.util.beanBR;

public class DBTool extends BaseDAO
{

    public DBTool()
    {
    }

    public String getStatusBR_ByID(String id)
        throws DBException
    {
        Connection conn;
        PreparedStatement preStmt;
        Statement stmt;
        ResultSet rs;
        String result;
        conn = null;
        preStmt = null;
        stmt = null;
        rs = null;
        String strSQL = null;
        result = "-1";
        try
        {
            conn = DBPool.getConnection();
            strSQL = "SELECT (CASE WHEN messageid = '-1' THEN '-1' WHEN messageid = '-2' THEN '-2' ELSE '0' END) AS messageid,to_char(time_send,'yyyymmddhh24miss') time_send FROM log_sms a where request_id='"+id+"'";
            preStmt = conn.prepareStatement(strSQL);
			
			rs = preStmt.executeQuery();
			
			while((rs != null) && (rs.next())){
				result = rs.getString("messageid")+"_"+rs.getString("time_send");
			}                

        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        releaseConnection(conn, preStmt, stmt, rs);
        return result;
    }

    public boolean insert2BR(beanBR bean)
        throws DBException
    {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String strSQL = null;
        boolean result = false;
        try
        {
            conn = DBPool.getConnection();
            strSQL = "INSERT INTO log_sms (account, phone_number,command_code, info, request_id,rout,smscount,mobileoperator,brandname,messageid) VALUES (?,?, ?,?, ?,?,?,?,?,?)";
            preStmt = conn.prepareStatement(strSQL);
            preStmt.setString(1, bean.getAccount());
            preStmt.setString(2, bean.getPhone_number());
            preStmt.setString(3, bean.getCommand_code());
            preStmt.setString(4, bean.getInfo());
            preStmt.setString(5, bean.getRequest_id());
            preStmt.setInt(6, bean.getRout());
            preStmt.setInt(7, bean.getSmsCount());
            preStmt.setString(8, bean.getMobileOperator());
            preStmt.setString(9, bean.getBrandname());
            preStmt.setString(10, bean.getMessageid());
            if(preStmt.executeUpdate() == 1)
                result = true;
        }
        catch(SQLException e)
        {
            System.out.println((new StringBuilder("insert2BR: Error executing ")).append(strSQL).append(" >>> ").append(e.toString()).toString());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("insert2BR: ")).append(e.toString()).toString());
        }
        finally
        {
            try
            {
                conn.setAutoCommit(true);
            }
            catch(SQLException sqlexception) { }
            releaseConnection(conn, preStmt);
         }
        return result;

    }

    public boolean update2BR(beanBR bean)
        throws DBException
    {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String strSQL = null;
        boolean result = false;
        try
        {
        	System.out.println((new StringBuilder("update2BR: ")).append(bean.getRequest_id()).toString());
            conn = DBPool.getConnection();
            strSQL = "update log_sms set rout=? , time_send=? , messageid=? where request_id=?";
            preStmt = conn.prepareStatement(strSQL);
            preStmt.setInt(1, bean.getRout());
            Calendar cal  = Calendar.getInstance();                    
            preStmt.setTimestamp(2, new java.sql.Timestamp(cal.getTimeInMillis()));
            preStmt.setString(3, bean.getMessageid());
            preStmt.setString(4, bean.getRequest_id());
            if(preStmt.executeUpdate() == 1)
                result = true;
        }
        catch(SQLException e)
        {
            System.out.println((new StringBuilder("update2BR: Error executing ")).append(strSQL).append(" >>> ").append(e.toString()).toString());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("update2BR: ")).append(e.toString()).toString());
        }
        finally
        {
            try
            {
                conn.setAutoCommit(true);
            }
            catch(SQLException sqlexception) { }
            releaseConnection(conn, preStmt);
        }
        return result;

    }
    
	public ArrayList getAllSMSFromDB() {
		
		ArrayList beans=new ArrayList();
		java.sql.Connection conn = null;
		PreparedStatement preStmt = null;
		String strSQL = null;
		ResultSet rs = null;
		beanBR bean=new beanBR();
		try {
			conn = DBPool.getConnection();
			strSQL = "SELECT phone_number, command_code, info, param_auto  FROM campsms where actives =1";
			preStmt = conn.prepareStatement(strSQL);
			
			rs = preStmt.executeQuery();
			
			while((rs != null) && (rs.next())){
				bean=new beanBR();
				bean.setPhone_number(rs.getString(1));
	            bean.setCommand_code(rs.getString(2));//phan biet tu nguon nao gui
	            bean.setInfo(rs.getString(3).replace("param#", rs.getString(4)));
 				beans.add(bean);
			}
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			releaseConnection(conn, preStmt, rs);
			
		}
		return beans;
	}
	
}
