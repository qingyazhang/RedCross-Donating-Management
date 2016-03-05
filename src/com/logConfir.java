package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logConfir extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		genImage newGen = (genImage)session.getAttribute("testImage");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String test = request.getParameter("test");
		String username = null;
		int auth = 0;
		String dbPass = null;
		String Imagecode = newGen.getRands();
		ResultSet rs = null;
		boolean isAdmin = false;
		querySum querysum = new querySum();
		int sum = querysum.getSum();
		
		
		try {
			DBConnector dbLog = new DBConnector();
			rs = dbLog.confirm(userID);
			while(rs.next())
			{
				dbPass = rs.getString("password");
				auth = rs.getInt("auth");
				username = rs.getString("username");
			}
			rs.close();
			dbLog.closeAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PrintWriter out = response.getWriter();
		if(test.equalsIgnoreCase(Imagecode) && password.equals(dbPass) )
		{
			if(auth == 1)
			{
				//重定向到管理员页面
				isAdmin = true;
				admin adminObject = new admin(userID,username,auth,dbPass);
				session.setAttribute("admin", adminObject);
				session.setAttribute("isAdmin", isAdmin);
				session.setAttribute("sum", sum);
				response.sendRedirect("index_admin.jsp");
				
			}
			else
			{
				//重定向到用户界面
				isAdmin = false;
				user userObject = new user(userID,username,auth,dbPass);
				session.setAttribute("user", userObject);
				session.setAttribute("isAdmin", isAdmin);
				session.setAttribute("sum", sum);
				response.sendRedirect("index_user.jsp");
			}
		}
		else
		{
			out.println("Wrong security code<br>");
			//重定向到错误页面重新登录
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doPost(request,response);
	}
}
