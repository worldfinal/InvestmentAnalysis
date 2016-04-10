package com.frc.investment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frc.investment.dao.IStockMarketDao;
import com.frc.investment.model.stockmarket.StockMarketRequest;
import com.frc.investment.model.stockmarket.StockMarketResponse;
import com.frc.investment.service.IStockMarketService;
import com.scorpiowf.utils.IOUtil;
import com.scorpiowf.utils.StringUtil;

@Service("RemoteStockMarketServiceImpl")
public class RemoteStockMarketServiceImpl implements IStockMarketService {
	private IStockMarketDao stockMarketDao = null;
	
	@Override
	public List<StockMarketResponse> queryResult(StockMarketRequest request) {
		String result = stockMarketDao.queryResult(request);
		String fileName = "StockMarket";
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		if (!StringUtil.isEmpty(request.getBeginDate()) || !StringUtil.isEmpty(request.getEndDate())) {
			fileName += "_Begin[" + request.getBeginDate() + "]";
			fileName += "_End[" + request.getEndDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getTradeDate())) {
			fileName += "_TradeDate[" + request.getTradeDate() + "]";
		}
		fileName += ".txt";
		String fullName = "D:\\output\\" + fileName;
		System.out.println("Length of data:" + result.length());
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}

	@Resource(name="RemoteStockMarketDao")
	public void setStockMarketDao(IStockMarketDao stockMarketDao) {
		this.stockMarketDao = stockMarketDao;
	}

}
