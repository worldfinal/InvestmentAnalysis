package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundNetValueRequest extends CommonRequest {
	//基金历史净值
	
	protected String dataDate;	 //输入一个日期，不输入其他请求参数，可获取到一天全部基金净值数据，输入格式“YYYYMMDD”
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
		
}
