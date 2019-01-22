package com.etc.HotelManagement.entity;

public class Room {
	private int rId;
	private String r_image;
	private String type;
	private String description;
	private double day_price;
	private int bedCount;
	private int rCount;
	

	public int getrCount() {
		return rCount;
	}

	public void setrCount(int rCount) {
		this.rCount = rCount;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getR_image() {
		return r_image;
	}

	public void setR_image(String r_image) {
		this.r_image = r_image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDay_price() {
		return day_price;
	}

	public void setDay_price(double day_price) {
		this.day_price = day_price;
	}

}
