package com.frc.investment.model.fund;

public class FundAssetsResponse {
	//基金资产配置
	
	protected String secID;	 //内部编码
	protected String reportDate;	 //报告日期
	protected String ticker;	 //基金代码
	protected String secShortName;	 //基金中文简称
	protected String totalAsset;	 //资产总值(元)
	protected String netAsset;	 //资产净值(元)
	protected String equityMarketValue;	 //股票市值(元)
	protected String bondMarketValue;	 //债券市值(元)
	protected String cashMarketValue;	 //现金市值(元)
	protected String otherMarketValue;	 //其他资产市值(元)
	protected String equityRatioInTa;	 //股票占资产总值的比例(%)
	protected String bondRatioInTa;	 //债券占资产总值的比例(%)
	protected String cashRatioInTa;	 //货币占资产总值的比例(%)
	protected String otherRatioInTa;	 //其它资产占资产总值的比例(%)
	protected String publishDate;	 //发布日期
	protected String currencyCd;	 //币种
	protected String updateTime;	 //数据最新一次更新时间
	public String getSecID() {
		return secID;
	}
	public void setSecID(String secID) {
		this.secID = secID;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
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
	public String getTotalAsset() {
		return totalAsset;
	}
	public void setTotalAsset(String totalAsset) {
		this.totalAsset = totalAsset;
	}
	public String getNetAsset() {
		return netAsset;
	}
	public void setNetAsset(String netAsset) {
		this.netAsset = netAsset;
	}
	public String getEquityMarketValue() {
		return equityMarketValue;
	}
	public void setEquityMarketValue(String equityMarketValue) {
		this.equityMarketValue = equityMarketValue;
	}
	public String getBondMarketValue() {
		return bondMarketValue;
	}
	public void setBondMarketValue(String bondMarketValue) {
		this.bondMarketValue = bondMarketValue;
	}
	public String getCashMarketValue() {
		return cashMarketValue;
	}
	public void setCashMarketValue(String cashMarketValue) {
		this.cashMarketValue = cashMarketValue;
	}
	public String getOtherMarketValue() {
		return otherMarketValue;
	}
	public void setOtherMarketValue(String otherMarketValue) {
		this.otherMarketValue = otherMarketValue;
	}
	public String getEquityRatioInTa() {
		return equityRatioInTa;
	}
	public void setEquityRatioInTa(String equityRatioInTa) {
		this.equityRatioInTa = equityRatioInTa;
	}
	public String getBondRatioInTa() {
		return bondRatioInTa;
	}
	public void setBondRatioInTa(String bondRatioInTa) {
		this.bondRatioInTa = bondRatioInTa;
	}
	public String getCashRatioInTa() {
		return cashRatioInTa;
	}
	public void setCashRatioInTa(String cashRatioInTa) {
		this.cashRatioInTa = cashRatioInTa;
	}
	public String getOtherRatioInTa() {
		return otherRatioInTa;
	}
	public void setOtherRatioInTa(String otherRatioInTa) {
		this.otherRatioInTa = otherRatioInTa;
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
