package com;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class queryAccept extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		String beginDate = request.getParameter("acceptBeginDate");
		String endDate = request.getParameter("acceptEndDate");
		String name = request.getParameter("acceptName");
		System.out.println(beginDate);
		System.out.println(endDate);
		if(name.equals("姓名"))
			name = "%%";
		ResultSet rs = null;
		List<accept> arrayResult = new ArrayList<accept>();
		
		try {
			DBConnector query = new DBConnector();
			rs = query.queryAcceptDetail(beginDate, endDate, name);
			while (rs.next())
			{
				arrayResult.add(new accept(rs.getString("acceptname"),rs.getInt("acceptnum"),rs.getString("accepttime")));
			}
			query.closeAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("acceptDetail", arrayResult);
		//request.getSession().setAttribute("acceptDetail", arrayResult);
		request.getRequestDispatcher("query_accept.jsp").forward(request, response);
	}
	
	

}
