package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundDivmRequest extends CommonRequest {
	//������ʷ����(������,�������ծȯ��)
	
	protected String dataDate;	 //����һ�����ڣ���������������������ɻ�ȡ��һ��ȫ��������ʷ�������ݣ������ʽ��YYYYMMDD��

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
	
}
