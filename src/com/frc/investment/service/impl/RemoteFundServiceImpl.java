package com.frc.investment.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frc.investment.dao.IFundDao;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundInformationResponse;
import com.frc.investment.service.IFundService;
import com.scorpiowf.utils.IOUtil;
import com.scorpiowf.utils.StringUtil;

@Service("RemoteFundServiceImpl")
public class RemoteFundServiceImpl implements IFundService {
	private IFundDao fundDao = null;

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

	@Resource(name="RemoteFundDao")
	public void setFundDao(IFundDao fundDao) {
		this.fundDao = fundDao;
	}

}
