package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;

public class FundDivmRequest extends CommonRequest {
	//基金历史收益(货币型,短期理财债券型)
	
	protected String dataDate;	 //输入一个日期，不输入其他请求参数，可获取到一天全部基金历史收益数据，输入格式“YYYYMMDD”

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
	
}
