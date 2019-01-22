package com.etc.HotelManagement.entity;


public class Customer {
	private int cuid;
	private String cuName;
	private String password;
	private int role;
	private double acount;	
	private String idNum;
	private String sex;	
	public int getCuid() {
		return cuid;
	}
	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	
	public double getAcount() {
		return acount;
	}
	public void setAcount(double acount) {
		this.acount = acount;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getCuName() {
		return cuName;
	}

	public void setCuName(String cuName) {
		this.cuName = cuName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
