package com.frc.investment.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.service.IFundService;

public class GetFund extends BaseClient{
	@BeforeTest
	public void beforeTest() {
		init();
	}
	
	@Test(dataProvider = "dp")
	public void process(String category, String listStatusCd, String etfLof, String ticker) {
		FundInformationRequest request = new FundInformationRequest();
		request.setCategory(category);
		request.setListStatusCd(listStatusCd);
		request.setEtfLof(etfLof);
		request.setTicker(ticker);
		IFundService fundService = (IFundService)ac.getBean("RemoteFundServiceImpl");
		fundService.queryResult(request);
	}
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] {"H", null, null, null},
			new Object[] {"B", null, null, null},
			new Object[] {"SB", null, null, null},
			new Object[] {"M", null, null, null},
			new Object[] {"O", null, null, null},
//			new Object[] {"H", "L"},
//			new Object[] {"B", "L"},
//			new Object[] {"SB", "L"},
//			new Object[] {"M", "L"},
//			new Object[] {"O", "L"},
//			new Object[] {null, null, "ETF", null},
//			new Object[] {null, null, "LOF", null},
//			new Object[] {null, null, null, "000545"}
			};
	}
	
	public void process() {
		FundInformationRequest request = new FundInformationRequest();
		request.setCategory("E");
		request.setListStatusCd("L");
		IFundService fundService = (IFundService)ac.getBean("RemoteFundServiceImpl");
		fundService.queryResult(request);
	}
}
