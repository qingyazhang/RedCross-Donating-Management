package com;
public class donate {
	private String donateName;
	private int donateNum;
	private String donateTime;
	private String province;
	private String city;
	public donate(String donateName,int donateNum,String donateTime,String province,String city)
	{
		this.donateName = donateName;
		this.donateNum = donateNum;
		this.province = province;
		this.city = city;
	}
	public String getDonateName() {
		return donateName;
	}
	public void setDonateName(String donateName) {
		this.donateName = donateName;
	}
	public int getDonateNum() {
		return donateNum;
	}
	public void setDonateNum(int donateNum) {
		this.donateNum = donateNum;
	}
	public String getDonateTime() {
		return donateTime;
	}
	public void setDonateTime(String donateTime) {
		this.donateTime = donateTime;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
