package com.etc.HotelManagement.entity;

import java.util.Date;

public class CheckIn {
	private int ciId;
	private Date check_Date;
	private int rNo;
	private String remarks;
	private String phoneNum;
    private int rId;
    private int cuId;
    private String cuName;
    private double totalprice;
    

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getCuName() {
		return cuName;
	}

	public void setCuName(String cuName) {
		this.cuName = cuName;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getCuId() {
		return cuId;
	}

	public void setCuId(int cuId) {
		this.cuId = cuId;
	}

	public int getCiId() {
		return ciId;
	}

	public void setCiId(int ciId) {
		this.ciId = ciId;
	}


	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getCheck_Date() {
		return check_Date;
	}

	public void setCheck_Date(Date check_Date) {
		this.check_Date = check_Date;
	}


	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
