package com.frc.investment.dao;

import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;

public interface IFundDao {
	//查询基金基本信息
	public String queryFund(FundInformationRequest request);
	
	//基金历史净值(货币型,短期理财债券型除外)
	public String getFundNav(FundNetValueRequest request);
	
	//基金历史收益(货币型,短期理财债券型)
	public String getFundDivm(FundNetValueRequest request);
	
	//基金资产配置
	public String getFundAssets(FundAssetsRequest request);
	
	//基金日行情
	public String getMarketFundd(MarketFundRequest request);
}
