package com.frc.investment.model.fund;

public class FundNavResponse {
	//������ʷ��ֵ(������,�������ծȯ�ͳ���)
	
	protected String secID;	 //�ڲ�����
	protected String endDate;	 //��ֵ����
	protected String ticker;	 //�������
	protected String secShortName;	 //�������ļ��
	protected String NAV;	 //��λ��ֵ(Ԫ)
	protected String publishDate;	 //��ֵ��������
	protected String ACCUM_NAV;	 //�ۼƾ�ֵ(Ԫ)
	protected String currencyCd;	 //�������ң�"CNY"Ϊ����ң�"HKD"Ϊ�۱ң�"USD"Ϊ��Ԫ
	protected String ADJUST_NAV;	 //��Ȩ��ֵ(Ԫ)
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
