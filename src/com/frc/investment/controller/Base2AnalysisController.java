package com.frc.investment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frc.investment.bean.Investment;
import com.frc.investment.model.Base2Date;
import com.frc.investment.model.Base2Request;
import com.frc.investment.model.Base2Response;
import com.frc.investment.service.InvestmentService;
import com.frc.investment.util.TimeIntervalUtil;

@Controller
@RequestMapping("/analysis")
public class Base2AnalysisController {
	@Resource(name="InvestmentService")
	private InvestmentService investmentService = null;
	
	@RequestMapping(value="/base2", method = RequestMethod.POST)
	public @ResponseBody Base2Response 
	retrieveResult(@RequestBody Base2Request request) {
		Base2Response response = new Base2Response();
		
		List<Investment> list = investmentService.retrieveInvestment(
				request.getFromDate(), request.getToDate(), request.getType());
		
		response.setTrades(new ArrayList<Base2Date>());
		response.setRequest(request);
		response.setMinLastDays(99999999);
		response.setMaxLastDays(-99999999);
		for (int i = 0; i < list.size(); i++) {
			Investment invt = list.get(i);
			if (invt.getMinPrice() <= request.getPrice() && invt.getMaxPrice() >= request.getPrice()) {
				//¿ª²Ö
				Base2Date trade = new Base2Date();
				trade.setInDate(invt.getDate());
				double finalPrice = request.getPrice();
				if ("BUY".equalsIgnoreCase(request.getParam())) {
					finalPrice += request.getEarn();
				} else {
					finalPrice -= request.getEarn();
				}
				for (int j = i + 1; j < list.size(); j++) {
					Investment closeInvt = list.get(j);
					if (closeInvt.getMinPrice() <= finalPrice && closeInvt.getMaxPrice() >= finalPrice) {
						trade.setOutDate(closeInvt.getDate());
						int lastDays = TimeIntervalUtil.calculateTimeInterval(trade.getInDate(), trade.getOutDate());
						trade.setLastDays(lastDays);
						if (lastDays > response.getMaxLastDays()) {
							response.setMaxLastDays(lastDays);
						}
						if (lastDays < response.getMinLastDays()) {
							response.setMinLastDays(lastDays);
						}
						break;
					}
				}
				response.getTrades().add(trade);
			}
		}
		return response;
	}
}
