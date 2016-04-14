package com.frc.investment.model.fund;

public class FundAssetsResponse {
	//�����ʲ�����
	
	protected String secID;	 //�ڲ�����
	protected String reportDate;	 //��������
	protected String ticker;	 //�������
	protected String secShortName;	 //�������ļ��
	protected String totalAsset;	 //�ʲ���ֵ(Ԫ)
	protected String netAsset;	 //�ʲ���ֵ(Ԫ)
	protected String equityMarketValue;	 //��Ʊ��ֵ(Ԫ)
	protected String bondMarketValue;	 //ծȯ��ֵ(Ԫ)
	protected String cashMarketValue;	 //�ֽ���ֵ(Ԫ)
	protected String otherMarketValue;	 //�����ʲ���ֵ(Ԫ)
	protected String equityRatioInTa;	 //��Ʊռ�ʲ���ֵ�ı���(%)
	protected String bondRatioInTa;	 //ծȯռ�ʲ���ֵ�ı���(%)
	protected String cashRatioInTa;	 //����ռ�ʲ���ֵ�ı���(%)
	protected String otherRatioInTa;	 //�����ʲ�ռ�ʲ���ֵ�ı���(%)
	protected String publishDate;	 //��������
	protected String currencyCd;	 //����
	protected String updateTime;	 //��������һ�θ���ʱ��
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
