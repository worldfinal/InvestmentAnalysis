package com.frc.investment.model.stockmarket;

import com.frc.investment.model.CommonRequest;

public class StockMarketRequest extends CommonRequest {
	protected String isOpen;
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
}
