package com.frc.investment.service;

import java.util.List;

import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundAssetsResponse;
import com.frc.investment.model.fund.FundDivmResponse;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundInformationResponse;
import com.frc.investment.model.fund.FundNavResponse;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;
import com.frc.investment.model.fund.MarketFundResponse;

public interface IFundService {
	// 查询基金基本信息
	public List<FundInformationResponse> queryResult(FundInformationRequest request);

	// 基金历史净值(货币型,短期理财债券型除外)
	public List<FundNavResponse> getFundNav(FundNetValueRequest request);

	// 基金历史收益(货币型,短期理财债券型)
	public List<FundDivmResponse> getFundDivm(FundNetValueRequest request);

	// 基金资产配置
	public List<FundAssetsResponse> getFundAssets(FundAssetsRequest request);

	// 基金日行情
	public List<MarketFundResponse> getMarketFundd(MarketFundRequest request);
}
