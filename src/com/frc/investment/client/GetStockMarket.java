package com.frc.investment.client;

import org.testng.annotations.Test;

import com.frc.investment.model.stockmarket.StockMarketRequest;
import com.frc.investment.service.IStockMarketService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class GetStockMarket {
	protected ApplicationContext ac = null;
	private static Logger log = Logger.getLogger(GetStockMarket.class);

//	@Test(dataProvider = "dp")
	public void startStockMarketService(String ticker, String tradeDate, String beginDate, String endDate) {
		if (ac == null) {
			log.error("Fail to init ApplicationContext");
			return;
		}
		log.debug("Start TestNG: StockMarket service");
		StockMarketRequest request = new StockMarketRequest();
		request.setTicker(ticker);
		request.setTradeDate(tradeDate);
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		IStockMarketService service = (IStockMarketService) ac.getBean("RemoteStockMarketServiceImpl");
		service.queryResult(request);
	}
	
	@Test
	public void test() throws ParseException, InterruptedException {
		String startDate = "20160422";
		String endDate = "20160611";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date1 = sdf.parse(startDate);
		Date date2 = sdf.parse(endDate);
		long delta = 24 * 60 * 60 * 1000;
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		while (d1 <= d2) {
			Date date = new Date(d1);
			String str = sdf.format(date);
//			System.out.println(str);
			d1 += delta;
			startStockMarketService(null, str, null, null);
			long time = (int)(Math.random() * 500);
			Thread.sleep(time);
		}
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] {null, "20160411", null, null},
	//		new Object[] {null, "20160408", null, null},
	//		new Object[] {"000100", null, "20160101", "20160131"},
	//		new Object[] {"000100", null, "20160201", "20160229"}
			};
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
