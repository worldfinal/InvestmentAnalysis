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
	// ��ѯ���������Ϣ
	public List<FundInformationResponse> queryResult(FundInformationRequest request);

	// ������ʷ��ֵ(������,�������ծȯ�ͳ���)
	public List<FundNavResponse> getFundNav(FundNetValueRequest request);

	// ������ʷ����(������,�������ծȯ��)
	public List<FundDivmResponse> getFundDivm(FundNetValueRequest request);

	// �����ʲ�����
	public List<FundAssetsResponse> getFundAssets(FundAssetsRequest request);

	// ����������
	public List<MarketFundResponse> getMarketFundd(MarketFundRequest request);
}
