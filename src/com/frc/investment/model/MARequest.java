package com.frc.investment.model;

public class MARequest {
	private String fromDate;
	private String toDate;
	private String operation;	//0 for buy, 1 for sell
	private String type;
	private double earn;
	private String param;
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getEarn() {
		return earn;
	}
	public void setEarn(double earn) {
		this.earn = earn;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
}
