package com.frc.investment.dao;

import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;

public interface IFundDao {
	//��ѯ���������Ϣ
	public String queryFund(FundInformationRequest request);
	
	//������ʷ��ֵ(������,�������ծȯ�ͳ���)
	public String getFundNav(FundNetValueRequest request);
	
	//������ʷ����(������,�������ծȯ��)
	public String getFundDivm(FundNetValueRequest request);
	
	//�����ʲ�����
	public String getFundAssets(FundAssetsRequest request);
	
	//����������
	public String getMarketFundd(MarketFundRequest request);
}
