package com.frc.investment.dao;

import com.frc.investment.model.fund.FundInformationRequest;

public interface IFundDao {
	public String queryFund(FundInformationRequest request);
}
