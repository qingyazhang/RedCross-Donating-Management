package com;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class queryProvince extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		ResultSet rs = null;
		List<province> arrayResult = new ArrayList<province>();
		
		try {
			DBConnector query = new DBConnector();
			rs = query.queryProvince(beginDate, endDate);
			while (rs.next())
			{
				arrayResult.add(new province(rs.getString("province"),rs.getInt("sum")));
			}
			query.closeAll();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("provinceDetail", arrayResult);
		//request.getSession().setAttribute("provinceDetail", arrayResult);
		request.getRequestDispatcher("province_detail.jsp").forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
