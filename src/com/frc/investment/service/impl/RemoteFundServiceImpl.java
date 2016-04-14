package com.frc.investment.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frc.investment.dao.IFundDao;
import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundAssetsResponse;
import com.frc.investment.model.fund.FundDivmResponse;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundInformationResponse;
import com.frc.investment.model.fund.FundNavResponse;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;
import com.frc.investment.model.fund.MarketFundResponse;
import com.frc.investment.service.IFundService;
import com.scorpiowf.utils.IOUtil;
import com.scorpiowf.utils.StringUtil;

@Service("RemoteFundServiceImpl")
public class RemoteFundServiceImpl implements IFundService {
	private IFundDao fundDao = null;
	@Resource(name="RemoteFundDao")
	public void setFundDao(IFundDao fundDao) {
		this.fundDao = fundDao;
	}

	@Override
	public List<FundInformationResponse> queryResult(FundInformationRequest request) {
		String fileName = "FundInfo";
		
		if (!StringUtil.isEmpty(request.getCategory())) {
			fileName += "_Cat[" + request.getCategory() + "]";
		}
		if (!StringUtil.isEmpty(request.getEtfLof())) {
			fileName += "_" + request.getEtfLof();
		}
		if (!StringUtil.isEmpty(request.getListStatusCd())) {
			fileName += "_Status[" + request.getListStatusCd() + "]";
		}
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		fileName += ".txt";
		String fullName = "D:\\output\\" + fileName;
		
		File file = new File(fullName);
		if (file.exists() && file.isFile()) {
			System.out.println("File already exists:" + fullName);
			return null;
		}
		
		String result = fundDao.queryFund(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}
	
	@Override
	public List<FundNavResponse> getFundNav(FundNetValueRequest request) {
		String fileName = "FundNav";
		if (!StringUtil.isEmpty(request.getDataDate())) {
			fileName += "_Date[" + request.getDataDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getBeginDate()) && !StringUtil.isEmpty(request.getEndDate())) {
			fileName += "_Begin[" + request.getBeginDate() + "]";
			fileName += "_End[" + request.getEndDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		
		fileName += ".txt";
		String fullName = "D:\\output\\FundNav\\" + request.getDataDate().substring(0, 4) + "\\";
		File file = new File(fullName);
		if (!file.exists()) {
			System.out.println("creating... " + fullName);
			file.mkdirs();
		}
		
		fullName += fileName;
		
		file = new File(fullName);
		if (file.exists() && file.isFile()) {
			System.out.println("File already exists:" + fullName);
			return null;
		}
		
		String result = fundDao.getFundNav(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}

	@Override
	public List<FundDivmResponse> getFundDivm(FundNetValueRequest request) {
		String fileName = "FundDivm";
		if (!StringUtil.isEmpty(request.getDataDate())) {
			fileName += "_Date[" + request.getDataDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getBeginDate()) && !StringUtil.isEmpty(request.getEndDate())) {
			fileName += "_Begin[" + request.getBeginDate() + "]";
			fileName += "_End[" + request.getEndDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		
		fileName += ".txt";
		String fullName = "D:\\output\\FundDivm\\" + request.getDataDate().substring(0, 4) + "\\";
		File file = new File(fullName);
		if (!file.exists()) {
			System.out.println("creating... " + fullName);
			file.mkdirs();
		}
		
		fullName += fileName;
		
		file = new File(fullName);
		if (file.exists() && file.isFile()) {
			System.out.println("File already exists:" + fullName);
			return null;
		}
		
		String result = fundDao.getFundDivm(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}
	
	@Override
	public List<FundAssetsResponse> getFundAssets(FundAssetsRequest request) {
		String fileName = "FundAssets";
		if (!StringUtil.isEmpty(request.getReportDate())) {
			fileName += "_Date[" + request.getReportDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getBeginDate()) && !StringUtil.isEmpty(request.getEndDate())) {
			fileName += "_Begin[" + request.getBeginDate() + "]";
			fileName += "_End[" + request.getEndDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		
		fileName += ".txt";
		String fullName = "D:\\output\\" + fileName;
		
		File file = new File(fullName);
		if (file.exists() && file.isFile()) {
			System.out.println("File already exists:" + fullName);
			return null;
		}
		
		String result = fundDao.getFundAssets(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}

	@Override
	public List<MarketFundResponse> getMarketFundd(MarketFundRequest request) {
		String fileName = "MarketFundd";
		if (!StringUtil.isEmpty(request.getTradeDate())) {
			fileName += "_Date[" + request.getTradeDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getBeginDate()) && !StringUtil.isEmpty(request.getEndDate())) {
			fileName += "_Begin[" + request.getBeginDate() + "]";
			fileName += "_End[" + request.getEndDate() + "]";
		}
		if (!StringUtil.isEmpty(request.getTicker())) {
			fileName += "_Ticker[" + request.getTicker() + "]";
		}
		if (!StringUtil.isEmpty(request.getSecID())) {
			fileName += "_SecID[" + request.getSecID() + "]";
		}
		
		fileName += ".txt";
		String fullName = "D:\\output\\" + fileName;
		
		File file = new File(fullName);
		if (file.exists() && file.isFile()) {
			System.out.println("File already exists:" + fullName);
			return null;
		}
		
		String result = fundDao.getMarketFundd(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}

}
