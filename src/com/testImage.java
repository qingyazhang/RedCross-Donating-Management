package com;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testImage extends HttpServlet {
	final int WIDTH = 100;
	final int HEIGHT = 30;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
		HttpSession session = request.getSession();
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		int R = (int)(Math.random()*255);
		int G = (int)(Math.random()*255);
		int B = (int)(Math.random()*255);
		graphic.setColor(new Color(R,G,B));
		graphic.fillRect(0, 0, 100, 30);
		genImage gen = new genImage(4);
		graphic = gen.draw(graphic);
		session.setAttribute("testImage", gen);
		ImageIO.write(image, "JPG", response.getOutputStream());
		
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
