package com.frc.investment.model;

public class Base1Response {
	//总共日数
	private int totleDays;
	
	//上升日数
	private int upDays;
	
	//下降日数
	private int downDays;
	
	private Base1Request request;
	
	public Base1Request getRequest() {
		return request;
	}
	public void setRequest(Base1Request request) {
		this.request = request;
	}
	public int getTotleDays() {
		return totleDays;
	}
	public void setTotleDays(int totleDays) {
		this.totleDays = totleDays;
	}
	public int getUpDays() {
		return upDays;
	}
	public void setUpDays(int upDays) {
		this.upDays = upDays;
	}
	public int getDownDays() {
		return downDays;
	}
	public void setDownDays(int downDays) {
		this.downDays = downDays;
	}
}
