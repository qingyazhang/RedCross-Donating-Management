package com;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBConnector {
	private final String URL = "jdbc:mysql://localhost:3306/redcross";
	private final String NAME = "root";
	private final String PASSWORD = "aovd2ss";
	private final String queryDonate = "SELECT sum(donatenum) AS sum FROM donate";
	private final String queryAccept = "SELECT sum(acceptnum) AS sum FROM accept";
	private String queryProvince = "SELECT province,sum(donatenum) AS sum FROM donate WHERE donatetime BETWEEN ? AND ? GROUP BY province";
	private String queryDonateDetail = "SELECT donatename,donatenum,donatetime,province,city FROM donate WHERE donatename LIKE ? AND donatetime BETWEEN ? AND ?";
	private String queryAcceptDetail = "SELECT acceptname,acceptnum,accepttime FROM accept WHERE acceptname LIKE ? AND accepttime BETWEEN ? AND ?";
	private String updateAuth = "UPDATE admin SET auth=? WHERE ID=?";
	private String logConfirm = "SELECT username,auth,password FROM admin WHERE ID=?";
	private String queryID = "SELECT * FROM admin WHERE id=?";
	private String insertUser = "INSERT INTO admin (username,password,ID,auth) VALUES (?,?,?,0)";
	private String registerDonate = "INSERT INTO doante(donatename,donatenum,donatetime,province,city) VLUES (?,?,?,?,?)";
	private String registerAccept = "INSERT INTO accept(acceptname,acceptid,acceptnum,accepttime) VALUES (?,?,?,?)";
	
	
	public Connection con = null;
	public ResultSet rs = null;
	public PreparedStatement preStmt = null;
	public DBConnector() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL,NAME,PASSWORD);
	}
	
	public ResultSet queryDonate()
	{
		try 
		{
			preStmt = con.prepareStatement(queryDonate);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet queryAccept()
	{
		try 
		{
			preStmt = con.prepareStatement(queryAccept);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet queryProvince(String d1,String d2)
	{
		java.sql.Date beginDate = strToSqlDate(d1);
		java.sql.Date endDate = strToSqlDate(d2);
		try 
		{
			preStmt = con.prepareStatement(queryProvince);
			preStmt.setDate(1, beginDate);
			preStmt.setDate(2, endDate);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet queryDonateDetail(String d1,String d2, String name)
	{
		java.sql.Date beginDate = strToSqlDate(d1);
		java.sql.Date endDate = strToSqlDate(d2);
		try 
		{
			preStmt = con.prepareStatement(queryDonateDetail);
			if(name != null)
				preStmt.setString(1, name);
			else
				preStmt.setString(1, "%%");
			preStmt.setDate(2, beginDate);
			preStmt.setDate(3, endDate);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet queryAcceptDetail(String d1,String d2, String name)
	{
		java.sql.Date beginDate = strToSqlDate(d1);
		java.sql.Date endDate = strToSqlDate(d2);
		try 
		{
			preStmt = con.prepareStatement(queryAcceptDetail);
			if(name != null)
				preStmt.setString(1, name);
			else
				preStmt.setString(1, "%%");
			preStmt.setDate(2, beginDate);
			preStmt.setDate(3, endDate);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public int updateAuth(int auth,String ID)
	{
		int tempRs = 0;
		try 
		{
			preStmt = con.prepareStatement(updateAuth);
			preStmt.setInt(1, auth);
			preStmt.setString(2, ID);
			tempRs = preStmt.executeUpdate();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempRs;
		
	}
	public int insertUser(String username, String password, String ID)
	{
		int complete = 0;
		try 
		{
			preStmt = con.prepareStatement(insertUser);
			preStmt.setString(1, username);
			preStmt.setString(2, password);
			preStmt.setString(3, ID);
			complete = preStmt.executeUpdate();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complete;
		
	}
	public ResultSet queryID(String ID)
	{
		
		try 
		{
			preStmt = con.prepareStatement(queryID);
			preStmt.setString(1, ID);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet confirm(String Id)
	{
		try 
		{
			preStmt = con.prepareStatement(logConfirm);
			preStmt.setString(1, Id);
			rs = preStmt.executeQuery();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public int registerDonate(String name,int num,String time,String province,String city)
	{
		int tempRs = 0;
		java.sql.Date sqlTime = strToSqlDate(time);
		try 
		{
			preStmt = con.prepareStatement(registerDonate);
			preStmt.setString(1, name);
			preStmt.setInt(2, num);
			preStmt.setDate(3, sqlTime);
			preStmt.setString(4, province);
			preStmt.setString(5, city);
			tempRs = preStmt.executeUpdate();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempRs;
		
	}
	
	
	public int registerAccept(String name,String acceptId,int num,String time)
	{
		int tempRs = 0;
		java.sql.Date sqlTime = strToSqlDate(time);
		try 
		{
			preStmt = con.prepareStatement(registerAccept);
			preStmt.setString(1, name);
			preStmt.setString(2, acceptId);
			preStmt.setInt(3, num);
			preStmt.setDate(4, sqlTime);
			tempRs = preStmt.executeUpdate();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempRs;
		
	}
	
	
	
	public void closeAll() throws SQLException
	{
		rs.close();
		preStmt.close();
		con.close();
	}
	public java.sql.Date strToSqlDate(String strDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		DBConnector db = new DBConnector();
		String d1 = "2015-12-30";
		String d2 = "2016-01-30";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;
		try {
			beginDate = sdf.parse(d1);
			endDate = sdf.parse(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDate1 = new java.sql.Date(beginDate.getTime());
		java.sql.Date sqlDate2 = new java.sql.Date(endDate.getTime());
		ResultSet rs1 = db.queryAcceptDetail(d1,d2,"李四");
		while(rs1.next())
		{
			System.out.println("此处为循环");
			System.out.println(rs1.getInt("acceptnum"));
		}
	}
	
	
}
