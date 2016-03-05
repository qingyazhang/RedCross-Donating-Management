package com;


import java.awt.Color;
import java.awt.Graphics;

public class genImage {
	int codeNum;
	String randCode;
	public genImage(int codeNum) {
		super();
		this.codeNum = codeNum;
	}
	
	
	public int getCodeNum() {
		return codeNum;
	}
	public String getRands() {
		return randCode;
	}
	
	public Graphics draw(Graphics g){
		char[] oriCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < codeNum; i ++)
		{
			sb.append(oriCode[(int)(Math.random()*62)]);
		}
		randCode = sb.toString();
		int R = (int)(Math.random()*255);
		int G = (int)(Math.random()*255);
		int B = (int)(Math.random()*255);
		g.setColor(new Color(R,G,B));
		for(int i = 0; i < codeNum; i ++)
		{
			g.drawString(" " + randCode.charAt(i), (100/codeNum)*i + 10 ,15 );
		}
		System.out.print(randCode);
		return g;
	}
}
