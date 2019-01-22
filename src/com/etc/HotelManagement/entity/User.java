package com.etc.HotelManagement.entity;

public class User {
	private int UId;
	private String UName;
	private String password;
	private int role;

	
	public int getUId() {
		return UId;
	}

	public void setUId(int uId) {
		UId = uId;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
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
