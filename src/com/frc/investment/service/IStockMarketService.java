package com.frc.investment.service;

import java.util.List;

import com.frc.investment.model.stockmarket.StockMarketRequest;
import com.frc.investment.model.stockmarket.StockMarketResponse;

public interface IStockMarketService {
	List<StockMarketResponse> queryResult(StockMarketRequest request);
}
