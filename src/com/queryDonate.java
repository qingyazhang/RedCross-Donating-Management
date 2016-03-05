package com;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class queryDonate extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		String beginDate = request.getParameter("donateBeginDate");
		String endDate = request.getParameter("doanteEndDate");
		String name = request.getParameter("donateName");
		System.out.println(name);
		if(name.equals("姓名"))
			name = "%%";
		ResultSet rs = null;
		List<donate> arrayResult = new ArrayList<donate>();
		
		try {
			DBConnector query = new DBConnector();
			rs = query.queryDonateDetail(beginDate, endDate, name);
			while (rs.next())
			{
				arrayResult.add(new donate(rs.getString("donatename"),rs.getInt("donatenum"),rs.getString("donatetime"),rs.getString("province"),rs.getString("city")));
			}
			rs.close();
			query.closeAll();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("donateDetail", arrayResult);
		//request.getSession().setAttribute("donateDetail", arrayResult);
		request.getRequestDispatcher("query_donate.jsp").forward(request, response);
	}
	
	

}
