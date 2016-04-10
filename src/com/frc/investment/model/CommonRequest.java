package com.frc.investment.model;

public class CommonRequest {
	protected String secID;
	protected String ticker;
	protected String tradeDate;
	protected String field;
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
}
