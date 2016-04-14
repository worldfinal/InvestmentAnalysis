package com.frc.investment.dao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;

import com.scorpiowf.utils.StringUtil;
import com.frc.investment.dao.GenericDao;
import com.frc.investment.dao.IFundDao;
import com.frc.investment.dao.IStockMarketDao;
import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;
import com.frc.investment.model.stockmarket.StockMarketRequest;

@Service("RemoteFundDao")
public class RemoteFundDao extends GenericDao implements IFundDao{
	public final String joiner = "&";
	
	public String queryFund(FundInformationRequest request) {
		String appUrl = "/api/fund/getFund.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "category=" + StringUtil.getStringValue(request.getCategory()) + joiner;
		param += "etfLof=" + StringUtil.getStringValue(request.getEtfLof()) + joiner;
		param += "listStatusCd=" + StringUtil.getStringValue(request.getListStatusCd()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "operationMode=" + StringUtil.getStringValue(request.getOperationMode()) + joiner;
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

	@Override
	public String getFundNav(FundNetValueRequest request) {
		String appUrl = "/api/fund/getFundNav.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "dataDate=" + StringUtil.getStringValue(request.getDataDate()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField()) + joiner;
		
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

	@Override
	public String getFundDivm(FundNetValueRequest request) {
		String appUrl = "/api/fund/getFundDivm.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "dataDate=" + StringUtil.getStringValue(request.getDataDate()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField()) + joiner;
		
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

	@Override
	public String getFundAssets(FundAssetsRequest request) {
		String appUrl = "/api/fund/getFundAssets.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "reportDate=" + StringUtil.getStringValue(request.getReportDate()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "updateTime=" + StringUtil.getStringValue(request.getUpdateTime()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField()) + joiner;
		
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

	@Override
	public String getMarketFundd(MarketFundRequest request) {
		String appUrl = "/api/market/getMktFundd.json?";
		String url = BASE_URL + appUrl;
		String param = "";
		param += "tradeDate=" + StringUtil.getStringValue(request.getTradeDate()) + joiner;
		param += "secID=" + StringUtil.getStringValue(request.getSecID()) + joiner;
		param += "ticker=" + StringUtil.getStringValue(request.getTicker()) + joiner;
		param += "beginDate=" + StringUtil.getStringValue(request.getBeginDate()) + joiner;
		param += "endDate=" + StringUtil.getStringValue(request.getEndDate()) + joiner;
		param += "field=" + StringUtil.getStringValue(request.getField()) + joiner;
		
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
