package com.frc.investment.dao;

import com.frc.investment.model.gold.GoldRequest;

public interface IGoldDao {
	public String queryGold(GoldRequest request);
}
