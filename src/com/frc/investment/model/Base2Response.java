package com.frc.investment.model;

import java.util.List;

public class Base2Response {
	private Base2Request request;
	private List<Base2Date> trades;
	private int minLastDays;
	private int maxLastDays;
	public Base2Request getRequest() {
		return request;
	}
	public void setRequest(Base2Request request) {
		this.request = request;
	}
	public List<Base2Date> getTrades() {
		return trades;
	}
	public void setTrades(List<Base2Date> trades) {
		this.trades = trades;
	}
	public int getMinLastDays() {
		return minLastDays;
	}
	public void setMinLastDays(int minLastDays) {
		this.minLastDays = minLastDays;
	}
	public int getMaxLastDays() {
		return maxLastDays;
	}
	public void setMaxLastDays(int maxLastDays) {
		this.maxLastDays = maxLastDays;
	}
}
