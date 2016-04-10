package com.frc.investment.model;

import java.util.List;

public class MAResponse {
	private MARequest request;
	private List<MAResult> trades;
	public MARequest getRequest() {
		return request;
	}
	public void setRequest(MARequest request) {
		this.request = request;
	}
	public List<MAResult> getTrades() {
		return trades;
	}
	public void setTrades(List<MAResult> trades) {
		this.trades = trades;
	}
}
