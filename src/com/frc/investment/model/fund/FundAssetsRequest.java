package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundAssetsRequest extends CommonRequest {
	//�����ʲ�����
	
	protected String reportDate;	 //����һ���������ڣ���20141231����������������������ɻ�ȡ���������ȫ�������ʲ����ã������ʽ��YYYYMMDD��
	protected String updateTime;	 //��������һ�θ���ʱ��

	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
