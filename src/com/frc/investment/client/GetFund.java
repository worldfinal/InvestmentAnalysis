package com.frc.investment.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.frc.investment.model.fund.FundAssetsRequest;
import com.frc.investment.model.fund.FundInformationRequest;
import com.frc.investment.model.fund.FundNetValueRequest;
import com.frc.investment.model.fund.MarketFundRequest;
import com.frc.investment.service.IFundService;

public class GetFund extends BaseClient{
	protected IFundService fundService = null;
	
	@BeforeTest
	public void beforeTest() {
		init();
		fundService = (IFundService)ac.getBean("RemoteFundServiceImpl");
	}
	
	@Test(dataProvider = "dp")
	public void process(String category, String listStatusCd, String etfLof, String ticker) {
		FundInformationRequest request = new FundInformationRequest();
		request.setCategory(category);
		request.setListStatusCd(listStatusCd);
		request.setEtfLof(etfLof);
		request.setTicker(ticker);
		fundService.queryResult(request);
	}
	
	@Test(dataProvider = "NetValue")
	public void getFundNav(String dataDate, String beginDate, String endDate, String ticker) {
		FundNetValueRequest request = new FundNetValueRequest();
		request.setDataDate(dataDate);
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		request.setTicker(ticker);
		fundService.getFundNav(request);
	}
	
	@Test(dataProvider = "NetValue")
	public void getFundDivm(String dataDate, String beginDate, String endDate, String ticker) {
		FundNetValueRequest request = new FundNetValueRequest();
		request.setDataDate(dataDate);
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		request.setTicker(ticker);
		fundService.getFundDivm(request);
	}
	
	@Test
	public void batchGetFundDivm() throws Exception {
		String startDate = "20060601";
		String endDate = "20060101";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date1 = sdf.parse(startDate);
		Date date2 = sdf.parse(endDate);
		long delta = 24 * 60 * 60 * 1000;
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		while (d1 >= d2) {
			Date date = new Date(d1);
			String str = sdf.format(date);
//			System.out.println(str);
			d1 -= delta;
			getFundDivm(str, null, null, null);
			long time = (int)(Math.random() * 50);
			Thread.sleep(time);
		}
	}
	
	@Test
	public void batchGetFundNav() throws Exception {
		String startDate = "20060406";
		String endDate = "20060406";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date1 = sdf.parse(startDate);
		Date date2 = sdf.parse(endDate);
		long delta = 24 * 60 * 60 * 1000;
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		while (d1 >= d2) {
			Date date = new Date(d1);
			String str = sdf.format(date);
//			System.out.println(str);
			d1 -= delta;
			getFundNav(str, null, null, null);
			long time = (int)(Math.random() * 300);
			Thread.sleep(time);
		}
	}
	
	@Test
	public void getFundAssets() {
		FundAssetsRequest request = new FundAssetsRequest();
		request.setReportDate(null);
		request.setTicker("000545");
		request.setBeginDate("20130101");
		request.setEndDate("20160411");
		fundService.getFundAssets(request);
	}
	
	@Test
	public void getMarketFund() {
		MarketFundRequest request = new MarketFundRequest();
		request.setTradeDate("20160412");
//		request.setSecID("000545.OFCN");
//		request.setTicker("000545");
//		request.setBeginDate("20160101");
//		request.setEndDate("20160412");
		fundService.getMarketFundd(request);
	}
	
	@DataProvider(name="dp")
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
	@DataProvider(name="NetValue")
	public Object[][] getNetValue() {
		return new Object[][] {
			new Object[] {"20160412", null, null, null},
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
