package com.frc.investment.model.stockmarket;

public class StockMarketResponse {
	protected String tradeDate;	 //交易日
	protected String ticker;	 //证券代码
	protected String secShortName;	 //证券简称
	protected String exchangeCD;	 //交易所代码
	protected String preClosePrice;	 //昨收盘
	protected String actPreClosePrice;	 //实际昨收盘
	protected String openPrice;	 //今开盘
	protected String highestPrice;	 //最高价
	protected String lowestPrice;	 //最低价
	protected String closePrice;	 //今收盘
	protected String turnoverVol;	 //成交量
	protected String turnoverValue;	 //成交金额
	protected String dealAmount;	 //成交笔数
	protected String turnoverRate;	 //日换手率
	protected String accumAdjFactor;	 //累积前复权因子，前复权是对历史行情进行调整，除权除息日的行情不受本次除权除息影响，不需进行调整。最新一次除权除息日至最新行情期间的价格不需要进行任何的调整，该期间前复权因子都是1。
	protected String negMarketValue;	 //流通市值
	protected String marketValue;	 //总市值
	protected String PE;	 //滚动市盈率,将于2016-01-01停止维护，推荐使用/api/market/getStockFactorsOneDay或/api/market/getStockFactorsDateRange，返回字段PE
	protected String PE1;	 //市盈率，将于2016-01-01停止维护，推荐使用/api/market/getStockFactorsOneDay或/api/market/getStockFactorsDateRange
	protected String PB;	 //市净率，将于2016-01-01停止维护，推荐使用/api/market/getStockFactorsOneDay或/api/market/getStockFactorsDateRange，返回字段PB
	protected String isOpen;	 //是否开盘
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
	public String getSecShortName() {
		return secShortName;
	}
	public void setSecShortName(String secShortName) {
		this.secShortName = secShortName;
	}
	public String getExchangeCD() {
		return exchangeCD;
	}
	public void setExchangeCD(String exchangeCD) {
		this.exchangeCD = exchangeCD;
	}
	public String getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(String preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public String getActPreClosePrice() {
		return actPreClosePrice;
	}
	public void setActPreClosePrice(String actPreClosePrice) {
		this.actPreClosePrice = actPreClosePrice;
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
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getTurnoverRate() {
		return turnoverRate;
	}
	public void setTurnoverRate(String turnoverRate) {
		this.turnoverRate = turnoverRate;
	}
	public String getAccumAdjFactor() {
		return accumAdjFactor;
	}
	public void setAccumAdjFactor(String accumAdjFactor) {
		this.accumAdjFactor = accumAdjFactor;
	}
	public String getNegMarketValue() {
		return negMarketValue;
	}
	public void setNegMarketValue(String negMarketValue) {
		this.negMarketValue = negMarketValue;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getPE() {
		return PE;
	}
	public void setPE(String pE) {
		PE = pE;
	}
	public String getPE1() {
		return PE1;
	}
	public void setPE1(String pE1) {
		PE1 = pE1;
	}
	public String getPB() {
		return PB;
	}
	public void setPB(String pB) {
		PB = pB;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

}
