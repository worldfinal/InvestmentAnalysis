package com.frc.investment.dao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;

import com.scorpiowf.utils.StringUtil;
import com.frc.investment.dao.GenericDao;
import com.frc.investment.dao.IFundDao;
import com.frc.investment.dao.IGoldDao;
import com.frc.investment.dao.IStockMarketDao;
import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;
import com.frc.investment.model.gold.GoldRequest;
import com.frc.investment.model.stockmarket.StockMarketRequest;

@Service("RemoteGoldDao")
public class RemoteGoldDao extends GenericDao implements IGoldDao{
	public final String joiner = "&";
	
	@Override
	public String queryGold(GoldRequest request) {
		String appUrl = "/api/market/getMktMFutd.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "tradeDate=" + StringUtil.getStringValue(request.getTradeDate()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField()) + joiner;
		System.out.println(param);
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
