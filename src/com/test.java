package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String s = request.getParameter("beginDate");
		System.out.println(s);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(s);
	}
}
