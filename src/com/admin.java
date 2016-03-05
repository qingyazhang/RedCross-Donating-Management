package com;
public class admin {
	private String ID;
	private String username;
	private int auth;
	private String password;
	
	public admin(String ID, String username,int auth,String password)
	{
		this.ID = ID;
		this.username = username;
		this.auth = auth;
		this.password = password;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
