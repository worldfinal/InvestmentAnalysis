package com.frc.investment.model.gold;

public class GoldResponse {
	protected String settlePrice;	 //�����
	protected String turnoverVol;	 //�ɽ������������ڻ��ɽ�����λΪ�֣������ڻ��ɽ�����λΪ�ţ��ƽ�(T+D)�����(T+D)�ɽ�����λΪǧ��
	protected String turnoverValue;	 //�ɽ����
	protected String openInt;	 //�ֲ����������ڻ��ֲ�����λΪ�֣������ڻ��ֲ�����λΪ�ţ��ƽ�(T+D)�����(T+D)�ֲ�����λΪǧ��
	protected String CHG;	 //�ǵ�
	protected String CHG1;	 //�ǵ�1
	protected String CHGPct;	 //�ǵ���
	protected String mainCon;	 //�Ƿ�����
	protected String smainCon;	 //�Ƿ������
	public String getSettlePrice() {
		return settlePrice;
	}
	public void setSettlePrice(String settlePrice) {
		this.settlePrice = settlePrice;
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
	public String getOpenInt() {
		return openInt;
	}
	public void setOpenInt(String openInt) {
		this.openInt = openInt;
	}
	public String getCHG() {
		return CHG;
	}
	public void setCHG(String cHG) {
		CHG = cHG;
	}
	public String getCHG1() {
		return CHG1;
	}
	public void setCHG1(String cHG1) {
		CHG1 = cHG1;
	}
	public String getCHGPct() {
		return CHGPct;
	}
	public void setCHGPct(String cHGPct) {
		CHGPct = cHGPct;
	}
	public String getMainCon() {
		return mainCon;
	}
	public void setMainCon(String mainCon) {
		this.mainCon = mainCon;
	}
	public String getSmainCon() {
		return smainCon;
	}
	public void setSmainCon(String smainCon) {
		this.smainCon = smainCon;
	}
}
