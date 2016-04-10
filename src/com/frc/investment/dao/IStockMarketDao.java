package com.frc.investment.dao;

import com.frc.investment.model.stockmarket.StockMarketRequest;

public interface IStockMarketDao {
	public String queryResult(StockMarketRequest request);
}
