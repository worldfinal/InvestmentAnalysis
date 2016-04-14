package com.frc.investment.model.fund;

import com.frc.investment.model.CommonRequest;


public class FundInformationRequest extends CommonRequest {
	//基金基本信息
	
	protected String category;	 //按投资对象分基金类型，E为股票型，H为混合型，B为债券型，SB为短期理财债券，M为货币型，O为其他
	protected String etfLof;	 //ETF或LOF型基金
	protected String listStatusCd;	 //上市状态，可选状态有:L-上市，S-暂停，DE-终止上市，UN-未上市。
	protected String operationMode;	 //基金运作模式，O为开放式，C为封闭式
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
