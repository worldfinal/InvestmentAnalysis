package com.frc.investment.model;

public class CommonRequest {
	protected String secID;
	protected String ticker;
	protected String tradeDate;
	protected String field;
	protected String beginDate;	 //起始日期，输入格式“YYYYMMDD”
	protected String endDate;	 //截止日期，输入格式“YYYYMMDD”
	public String getSecID() {
		return secID;
	}
	public void setSecID(String secID) {
		this.secID = secID;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
