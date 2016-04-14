package com.frc.investment.model.fund;

public class FundNavResponse {
	//基金历史净值(货币型,短期理财债券型除外)
	
	protected String secID;	 //内部编码
	protected String endDate;	 //净值日期
	protected String ticker;	 //基金代码
	protected String secShortName;	 //基金中文简称
	protected String NAV;	 //单位净值(元)
	protected String publishDate;	 //净值公布日期
	protected String ACCUM_NAV;	 //累计净值(元)
	protected String currencyCd;	 //计量货币，"CNY"为人民币，"HKD"为港币，"USD"为美元
	protected String ADJUST_NAV;	 //复权净值(元)
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
	public String getNAV() {
		return NAV;
	}
	public void setNAV(String nAV) {
		NAV = nAV;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getACCUM_NAV() {
		return ACCUM_NAV;
	}
	public void setACCUM_NAV(String aCCUM_NAV) {
		ACCUM_NAV = aCCUM_NAV;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getADJUST_NAV() {
		return ADJUST_NAV;
	}
	public void setADJUST_NAV(String aDJUST_NAV) {
		ADJUST_NAV = aDJUST_NAV;
	}
}
