package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;


public class FundInformationRequest extends CommonRequest {
	//���������Ϣ
	
	protected String category;	 //��Ͷ�ʶ���ֻ������ͣ�EΪ��Ʊ�ͣ�HΪ����ͣ�BΪծȯ�ͣ�SBΪ�������ծȯ��MΪ�����ͣ�OΪ����
	protected String etfLof;	 //ETF��LOF�ͻ���
	protected String listStatusCd;	 //����״̬����ѡ״̬��:L-���У�S-��ͣ��DE-��ֹ���У�UN-δ���С�
	protected String operationMode;	 //��������ģʽ��OΪ����ʽ��CΪ���ʽ
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEtfLof() {
		return etfLof;
	}
	public void setEtfLof(String etfLof) {
		this.etfLof = etfLof;
	}
	public String getListStatusCd() {
		return listStatusCd;
	}
	public void setListStatusCd(String listStatusCd) {
		this.listStatusCd = listStatusCd;
	}
	public String getOperationMode() {
		return operationMode;
	}
	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}
}
