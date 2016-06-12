package com.frc.investment.model.gold;

public class GoldResponse {
	protected String settlePrice;	 //结算价
	protected String turnoverVol;	 //成交数量，国内期货成交量单位为手，国际期货成交量单位为张，黄金(T+D)与白银(T+D)成交量单位为千克
	protected String turnoverValue;	 //成交金额
	protected String openInt;	 //持仓量，国内期货持仓量单位为手，国际期货持仓量单位为张，黄金(T+D)与白银(T+D)持仓量单位为千克
	protected String CHG;	 //涨跌
	protected String CHG1;	 //涨跌1
	protected String CHGPct;	 //涨跌幅
	protected String mainCon;	 //是否主力
	protected String smainCon;	 //是否次主力
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
