package com.frc.investment.service;

import java.util.List;

import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundInformationResponse;

public interface IFundService {
	public List<FundInformationResponse> queryResult(FundInformationRequest request);
}
