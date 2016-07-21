package com.frc.investment.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frc.investment.dao.IGoldDao;
import com.frc.investment.model.gold.GoldRequest;
import com.frc.investment.model.gold.GoldResponse;
import com.frc.investment.service.IGoldService;
import com.scorpiowf.utils.IOUtil;
import com.scorpiowf.utils.StringUtil;

@Service("RemoteGoldServiceImpl")
public class RemoteGoldServiceImpl implements IGoldService {
	private IGoldDao goldDao = null;
	
	@Override
	public List<GoldResponse> queryResult(GoldRequest request) {
		String fileName = "Gold";
		
		if (!StringUtil.isEmpty(request.getTradeDate())) {
			fileName += "_Date[" + request.getTradeDate() + "]";
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
		
		String result = goldDao.queryGold(request);
		System.out.println("Output to : " +fullName);
		IOUtil.writeStringToFile(fullName, result);
		return null;
	}

	@Resource(name="RemoteGoldDao")
	public void setGoldDao(IGoldDao goldDao) {
		this.goldDao = goldDao;
	}

}
