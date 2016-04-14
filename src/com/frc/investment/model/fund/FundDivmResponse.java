package com.frc.investment.model.fund;

public class FundDivmResponse {
	//基金历史收益(货币型,短期理财债券型)
	
	protected String secID;	 //内部编码
	protected String endDate;	 //收益日期
	protected String ticker;	 //交易代码
	protected String secShortName;	 //基金中文简称
	protected String dailyProfit;	 //每万份基金单位当日收益(元)
	protected String weeklyYield;	 //7日年化收益率(%)
	protected String publishDate;	 //发布日期
	protected String currencyCd;	 //币种
	public String getSecID() {
		return secID;
	}
	public void setSecID(String secID) {
		this.secID = secID;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getDailyProfit() {
		return dailyProfit;
	}
	public void setDailyProfit(String dailyProfit) {
		this.dailyProfit = dailyProfit;
	}
	public String getWeeklyYield() {
		return weeklyYield;
	}
	public void setWeeklyYield(String weeklyYield) {
		this.weeklyYield = weeklyYield;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

}
