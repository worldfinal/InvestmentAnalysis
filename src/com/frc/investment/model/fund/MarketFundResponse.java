package com.frc.investment.model.fund;

public class MarketFundResponse {
	//����������
	
	protected String secID;	 //֤ȯID
	protected String tradeDate;	 //��������
	protected String ticker;	 //�����״���
	protected String exchangeCD;	 //�����г�����
	protected String secShortName;	 //֤ȯ���
	protected String preClosePrice;	 //������
	protected String openPrice;	 //����
	protected String highestPrice;	 //��߼�
	protected String lowestPrice;	 //��ͼ�
	protected String closePrice;	 //���̼�
	protected String CHG;	 //�ǵ�
	protected String CHGPct;	 //�ǵ���
	protected String turnoverVol;	 //�ɽ���
	protected String turnoverValue;	 //�ɽ����
	protected String discount;	 //��ˮ
	protected String discountRatio;	 //��ˮ��
	protected String circulationShares;	 //��ͨ�ݶ�
	protected String accumAdjFactor;	 //�ۻ���Ȩ����
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
