package com.frc.investment.model.fund;

public class FundDivmResponse {
	//������ʷ����(������,�������ծȯ��)
	
	protected String secID;	 //�ڲ�����
	protected String endDate;	 //��������
	protected String ticker;	 //���״���
	protected String secShortName;	 //�������ļ��
	protected String dailyProfit;	 //ÿ��ݻ���λ��������(Ԫ)
	protected String weeklyYield;	 //7���껯������(%)
	protected String publishDate;	 //��������
	protected String currencyCd;	 //����
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
