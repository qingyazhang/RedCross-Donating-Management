package com;


public class accept {
	private String acceptName;
	private int acceptNum;
	private String acceptTime;
	
	public accept(String acceptName,int acceptNum,String acceptTime)
	{
		this.acceptName = acceptName;
		this.acceptNum = acceptNum;
		this.acceptTime = acceptTime;
	}
	
	public String getAcceptName() {
		return acceptName;
	}
	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}
	public int getAcceptNum() {
		return acceptNum;
	}
	public void setAcceptNum(int acceptNum) {
		this.acceptNum = acceptNum;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	
}
