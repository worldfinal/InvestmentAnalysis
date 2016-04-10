package com.frc.investment.dao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;

import com.scorpiowf.utils.StringUtil;
import com.frc.investment.dao.GenericDao;
import com.frc.investment.dao.IStockMarketDao;
import com.frc.investment.model.stockmarket.StockMarketRequest;

@Service("RemoteStockMarketDao")
public class RemoteStockMarketDao extends GenericDao implements IStockMarketDao{
	public String queryResult(StockMarketRequest request) {
		final String joiner = "&";
		String appUrl = "/api/market/getMktEqud.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "tradeDate=" + StringUtil.getStringValue(request.getTradeDate()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "isOpen=" + StringUtil.getStringValue(request.getIsOpen()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField());
		try {
			param = java.net.URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		url += param;
		
		try {
			String result = sendRequest(url);
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
