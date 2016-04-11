package com.frc.investment.model.fund;

public class FundInformationResponse {
	protected String secID;	 //�ڲ�����
	protected String ticker;	 //�������
	protected String secShortName;	 //�������ļ��
	protected String tradeAbbrName;	 //���׼��
	protected String category;	 //��Ͷ�ʶ���ֻ������ͣ�EΪ��Ʊ�ͣ�HΪ����ͣ�BΪծȯ�ͣ�SBΪ�������ծȯ��MΪ�����ͣ�OΪ����
	protected String operationMode;	 //��������ģʽ��OΪ����ʽ��CΪ���ʽ
	protected String indexFund;	 //����ָ�������ԣ�IΪָ���ͣ�EIΪָ����ǿ��
	protected String etfLof;	 //ETF��LOF�ͻ���
	protected String isQdii;	 //�Ƿ�ΪQDII����1Ϊ�ǣ�0Ϊ��
	protected String isFof;	 //�Ƿ�ΪFOF����1Ϊ�ǣ�0Ϊ��
	protected String isGuarFund;	 //�Ƿ�Ϊ��������1Ϊ�ǣ�0Ϊ��
	protected String guarPeriod;	 //��������(��)
	protected String guarRatio;	 //��������(%)
	protected String exchangeCd;	 //����������
	protected String listStatusCd;	 //����״̬��L-���У�S-��ͣ��DE-��ֹ���У�UN-δ���С�
	protected String managerName;	 //������
	protected String establishDate;	 //�����������
	protected String listDate;	 //��������
	protected String delistDate;	 //��ֹ��������
	protected String managementCompany;	 //��������˱���
	protected String managementFullName;	 //�������������ȫ��
	protected String custodian;	 //�����й��˱���
	protected String custodianFullName;	 //�����й�������ȫ��
	protected String investField;	 //Ͷ������
	protected String investTarget;	 //Ͷ��Ŀ��
	protected String perfBenchmark;	 //ҵ���Ƚϻ�׼
	protected String circulationShares;	 //������ͨ�ݶ�
	protected String isClass;	 //�Ƿ�ּ�����,1Ϊĸ����,2Ϊ�ӻ���A,3Ϊ�ӻ���B,0Ϊ��
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
