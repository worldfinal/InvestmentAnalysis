package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundNetValueRequest extends CommonRequest {
	//������ʷ��ֵ
	
	protected String dataDate;	 //����һ�����ڣ���������������������ɻ�ȡ��һ��ȫ������ֵ���ݣ������ʽ��YYYYMMDD��
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
		
}
