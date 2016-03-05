package com;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerUser extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String ID = request.getParameter("ID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatPassord = request.getParameter("repeatPassword");
		ResultSet rs = null;
		
		if(password.equals(repeatPassord))
		{
			DBConnector addUser;
			try {
				addUser = new DBConnector();
				rs = addUser.queryID(ID);
				if(!rs.next())
				{
					//账号为被注册过，可以使用此ID
					int flag = addUser.insertUser(username, password, ID);
					if(flag == 1)
					{
						//注册成功，到达某个页面重新登录
					}
					else
					{
						//注册失败，请联系管理员
					}
				}
				else
				{
					//此账号已被注册过，请更换一个ID
				}
				addUser.closeAll();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			//输出错误信息，密码两次输入不一致
			
		}
		
		//request.setAttribute("donateDetail", arrayResult);
		//request.getSession().setAttribute("donateDetail", arrayResult);
		//request.getRequestDispatcher("donate_detail.jsp").forward(request, response);
	}
	
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
