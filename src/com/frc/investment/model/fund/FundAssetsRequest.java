package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundAssetsRequest extends CommonRequest {
	//基金资产配置
	
	protected String reportDate;	 //输入一个报告日期，如20141231，不输入其他请求参数，可获取这个报告期全部基金资产配置，输入格式“YYYYMMDD”
	protected String updateTime;	 //数据最新一次更新时间

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
