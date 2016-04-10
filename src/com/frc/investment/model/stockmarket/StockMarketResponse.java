package com.frc.investment.model.stockmarket;

public class StockMarketResponse {
	protected String tradeDate;	 //������
	protected String ticker;	 //֤ȯ����
	protected String secShortName;	 //֤ȯ���
	protected String exchangeCD;	 //����������
	protected String preClosePrice;	 //������
	protected String actPreClosePrice;	 //ʵ��������
	protected String openPrice;	 //����
	protected String highestPrice;	 //��߼�
	protected String lowestPrice;	 //��ͼ�
	protected String closePrice;	 //������
	protected String turnoverVol;	 //�ɽ���
	protected String turnoverValue;	 //�ɽ����
	protected String dealAmount;	 //�ɽ�����
	protected String turnoverRate;	 //�ջ�����
	protected String accumAdjFactor;	 //�ۻ�ǰ��Ȩ���ӣ�ǰ��Ȩ�Ƕ���ʷ������е�������Ȩ��Ϣ�յ����鲻�ܱ��γ�Ȩ��ϢӰ�죬������е���������һ�γ�Ȩ��Ϣ�������������ڼ�ļ۸���Ҫ�����κεĵ��������ڼ�ǰ��Ȩ���Ӷ���1��
	protected String negMarketValue;	 //��ͨ��ֵ
	protected String marketValue;	 //����ֵ
	protected String PE;	 //������ӯ��,����2016-01-01ֹͣά�����Ƽ�ʹ��/api/market/getStockFactorsOneDay��/api/market/getStockFactorsDateRange�������ֶ�PE
	protected String PE1;	 //��ӯ�ʣ�����2016-01-01ֹͣά�����Ƽ�ʹ��/api/market/getStockFactorsOneDay��/api/market/getStockFactorsDateRange
	protected String PB;	 //�о��ʣ�����2016-01-01ֹͣά�����Ƽ�ʹ��/api/market/getStockFactorsOneDay��/api/market/getStockFactorsDateRange�������ֶ�PB
	protected String isOpen;	 //�Ƿ���
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
