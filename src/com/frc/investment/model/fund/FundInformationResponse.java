package com.frc.investment.model.fund;

public class FundInformationResponse {
	protected String secID;	 //内部编码
	protected String ticker;	 //基金代码
	protected String secShortName;	 //基金中文简称
	protected String tradeAbbrName;	 //交易简称
	protected String category;	 //按投资对象分基金类型，E为股票型，H为混合型，B为债券型，SB为短期理财债券，M为货币型，O为其他
	protected String operationMode;	 //基金运作模式，O为开放式，C为封闭式
	protected String indexFund;	 //基金指数型属性，I为指数型，EI为指数增强型
	protected String etfLof;	 //ETF或LOF型基金
	protected String isQdii;	 //是否为QDII基金，1为是，0为否
	protected String isFof;	 //是否为FOF基金，1为是，0为否
	protected String isGuarFund;	 //是否为保本基金，1为是，0为否
	protected String guarPeriod;	 //保本周期(月)
	protected String guarRatio;	 //保本比例(%)
	protected String exchangeCd;	 //交易所代码
	protected String listStatusCd;	 //上市状态：L-上市，S-暂停，DE-终止上市，UN-未上市。
	protected String managerName;	 //基金经理
	protected String establishDate;	 //基金成立日期
	protected String listDate;	 //上市日期
	protected String delistDate;	 //终止上市日期
	protected String managementCompany;	 //基金管理人编码
	protected String managementFullName;	 //基金管理人中文全称
	protected String custodian;	 //基金托管人编码
	protected String custodianFullName;	 //基金托管人中文全称
	protected String investField;	 //投资领域
	protected String investTarget;	 //投资目标
	protected String perfBenchmark;	 //业绩比较基准
	protected String circulationShares;	 //最新流通份额
	protected String isClass;	 //是否分级基金,1为母基金,2为子基金A,3为子基金B,0为否
	public String getSecID() {
		return secID;
	}
	public void setSecID(String secID) {
		this.secID = secID;
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
	public String getTradeAbbrName() {
		return tradeAbbrName;
	}
	public void setTradeAbbrName(String tradeAbbrName) {
		this.tradeAbbrName = tradeAbbrName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOperationMode() {
		return operationMode;
	}
	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}
	public String getIndexFund() {
		return indexFund;
	}
	public void setIndexFund(String indexFund) {
		this.indexFund = indexFund;
	}
	public String getEtfLof() {
		return etfLof;
	}
	public void setEtfLof(String etfLof) {
		this.etfLof = etfLof;
	}
	public String getIsQdii() {
		return isQdii;
	}
	public void setIsQdii(String isQdii) {
		this.isQdii = isQdii;
	}
	public String getIsFof() {
		return isFof;
	}
	public void setIsFof(String isFof) {
		this.isFof = isFof;
	}
	public String getIsGuarFund() {
		return isGuarFund;
	}
	public void setIsGuarFund(String isGuarFund) {
		this.isGuarFund = isGuarFund;
	}
	public String getGuarPeriod() {
		return guarPeriod;
	}
	public void setGuarPeriod(String guarPeriod) {
		this.guarPeriod = guarPeriod;
	}
	public String getGuarRatio() {
		return guarRatio;
	}
	public void setGuarRatio(String guarRatio) {
		this.guarRatio = guarRatio;
	}
	public String getExchangeCd() {
		return exchangeCd;
	}
	public void setExchangeCd(String exchangeCd) {
		this.exchangeCd = exchangeCd;
	}
	public String getListStatusCd() {
		return listStatusCd;
	}
	public void setListStatusCd(String listStatusCd) {
		this.listStatusCd = listStatusCd;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	public String getListDate() {
		return listDate;
	}
	public void setListDate(String listDate) {
		this.listDate = listDate;
	}
	public String getDelistDate() {
		return delistDate;
	}
	public void setDelistDate(String delistDate) {
		this.delistDate = delistDate;
	}
	public String getManagementCompany() {
		return managementCompany;
	}
	public void setManagementCompany(String managementCompany) {
		this.managementCompany = managementCompany;
	}
	public String getManagementFullName() {
		return managementFullName;
	}
	public void setManagementFullName(String managementFullName) {
		this.managementFullName = managementFullName;
	}
	public String getCustodian() {
		return custodian;
	}
	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	public String getCustodianFullName() {
		return custodianFullName;
	}
	public void setCustodianFullName(String custodianFullName) {
		this.custodianFullName = custodianFullName;
	}
	public String getInvestField() {
		return investField;
	}
	public void setInvestField(String investField) {
		this.investField = investField;
	}
	public String getInvestTarget() {
		return investTarget;
	}
	public void setInvestTarget(String investTarget) {
		this.investTarget = investTarget;
	}
	public String getPerfBenchmark() {
		return perfBenchmark;
	}
	public void setPerfBenchmark(String perfBenchmark) {
		this.perfBenchmark = perfBenchmark;
	}
	public String getCirculationShares() {
		return circulationShares;
	}
	public void setCirculationShares(String circulationShares) {
		this.circulationShares = circulationShares;
	}
	public String getIsClass() {
		return isClass;
	}
	public void setIsClass(String isClass) {
		this.isClass = isClass;
	}

}
