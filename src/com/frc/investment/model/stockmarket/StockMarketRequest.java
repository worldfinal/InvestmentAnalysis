package com.frc.investment.model.stockmarket;

import com.frc.investment.model.CommonRequest;

public class StockMarketRequest extends CommonRequest {
	protected String beginDate;
	protected String endDate;
	protected String isOpen;
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
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
}
