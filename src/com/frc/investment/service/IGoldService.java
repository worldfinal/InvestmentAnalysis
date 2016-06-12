package com.frc.investment.service;

import java.util.List;

import com.frc.investment.model.gold.GoldRequest;
import com.frc.investment.model.gold.GoldResponse;


public interface IGoldService {
	public List<GoldResponse> queryResult(GoldRequest request);
}
