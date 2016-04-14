package com.frc.investment.model.fund;

public class MarketFundResponse {
	//基金日行情
	
	protected String secID;	 //证券ID
	protected String tradeDate;	 //交易日期
	protected String ticker;	 //基金交易代码
	protected String exchangeCD;	 //交易市场编码
	protected String secShortName;	 //证券简称
	protected String preClosePrice;	 //昨收盘
	protected String openPrice;	 //今开盘
	protected String highestPrice;	 //最高价
	protected String lowestPrice;	 //最低价
	protected String closePrice;	 //收盘价
	protected String CHG;	 //涨跌
	protected String CHGPct;	 //涨跌幅
	protected String turnoverVol;	 //成交量
	protected String turnoverValue;	 //成交金额
	protected String discount;	 //贴水
	protected String discountRatio;	 //贴水率
	protected String circulationShares;	 //流通份额
	protected String accumAdjFactor;	 //累积复权因子
	public String getSecID() {
		return secID;
	}
	public void setSecID(String secID) {
		this.secID = secID;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getExchangeCD() {
		return exchangeCD;
	}
	public void setExchangeCD(String exchangeCD) {
		this.exchangeCD = exchangeCD;
	}
	public String getSecShortName() {
		return secShortName;
	}
	public void setSecShortName(String secShortName) {
		this.secShortName = secShortName;
	}
	public String getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(String preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public String getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}
	public String getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(String highestPrice) {
		this.highestPrice = highestPrice;
	}
	public String getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public String getCHG() {
		return CHG;
	}
	public void setCHG(String cHG) {
		CHG = cHG;
	}
	public String getCHGPct() {
		return CHGPct;
	}
	public void setCHGPct(String cHGPct) {
		CHGPct = cHGPct;
	}
	public String getTurnoverVol() {
		return turnoverVol;
	}
	public void setTurnoverVol(String turnoverVol) {
		this.turnoverVol = turnoverVol;
	}
	public String getTurnoverValue() {
		return turnoverValue;
	}
	public void setTurnoverValue(String turnoverValue) {
		this.turnoverValue = turnoverValue;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDiscountRatio() {
		return discountRatio;
	}
	public void setDiscountRatio(String discountRatio) {
		this.discountRatio = discountRatio;
	}
	public String getCirculationShares() {
		return circulationShares;
	}
	public void setCirculationShares(String circulationShares) {
		this.circulationShares = circulationShares;
	}
	public String getAccumAdjFactor() {
		return accumAdjFactor;
	}
	public void setAccumAdjFactor(String accumAdjFactor) {
		this.accumAdjFactor = accumAdjFactor;
	}

}
