package com.frc.investment.model;

public class Base2Request {
	private String fromDate;
	private String toDate;
	
	/*
	 * BUY
	 * SELL
	 * */
	private String param;

	//e.g. AGTD, XAGUSD
	private String type;
	private double price;
	private double earn;
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getEarn() {
		return earn;
	}
	public void setEarn(double earn) {
		this.earn = earn;
	}
	
}
