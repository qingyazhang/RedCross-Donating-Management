package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class querySum{
	private int sum;
	public int getSum()
	{
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int doSum = 0;
		int acSum = 0;
		try {
			DBConnector query = new DBConnector();
			rs1 = query.queryDonate();
			rs2 = query.queryAccept();
			while (rs1.next())
			{
				doSum = rs1.getInt("sum");
			}
			while(rs2.next())
			{
				acSum = rs2.getInt("sum");
			}
			rs1.close();
			rs2.close();
			query.closeAll();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sum = doSum - acSum;
		return sum;
}
}
