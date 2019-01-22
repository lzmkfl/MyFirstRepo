package com.etc.HotelManagement.entity;

public class RoomDetail {
	private int rdId;
	private int rNo;
	private String type;
	private String state;
	private String remarks;
    private int rId;

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getRdId() {
		return rdId;
	}

	public void setRdId(int rdId) {
		this.rdId = rdId;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
