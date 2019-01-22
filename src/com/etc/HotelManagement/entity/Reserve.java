package com.etc.HotelManagement.entity;

import java.util.Date;

public class Reserve {
	private int reId;
	private String reCuName;
	private String sex;
	private Date checkInDate;
	private Date leaveDate;
	private Double TotalMonney;
	private String remarks;
	private String idNum;
	private String type;
	private int rId;
	private int cuId;
	
	
	
	public int getCuId() {
		return cuId;
	}

	public void setCuId(int cuId) {
		this.cuId = cuId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public String getReCuName() {
		return reCuName;
	}

	public void setReCuName(String reCuName) {
		this.reCuName = reCuName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public Double getTotalMonney() {
		return TotalMonney;
	}

	public void setTotalMonney(Double totalMonney) {
		TotalMonney = totalMonney;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
