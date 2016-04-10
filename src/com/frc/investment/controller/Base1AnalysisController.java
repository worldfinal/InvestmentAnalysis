package com.frc.investment.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frc.investment.bean.Investment;
import com.frc.investment.model.Base1Request;
import com.frc.investment.model.Base1Response;
import com.frc.investment.service.InvestmentService;

@Controller
@RequestMapping("/analysis")
public class Base1AnalysisController {
	@Resource(name="InvestmentService")
	private InvestmentService investmentService = null;
	
	@RequestMapping(value="/base1", method = RequestMethod.POST)
	public @ResponseBody Base1Response 
	retrieveResult(@RequestBody Base1Request request) {
		Base1Response response = new Base1Response();
		
		List<Investment> list = investmentService.retrieveInvestment(
				request.getFromDate(), request.getToDate(), request.getType());
		
		String param = request.getParam();
		int ttl = 0;
		int up = 0;
		int down = 0;
		for (int i = 0; i < list.size(); i++) {
			Investment inv = list.get(i);
			if ("1".equals(param)) {
				//价格高于
				if (inv.getStopPrice() > request.getPrice()) {
					ttl++;
					if (inv.getStopPrice() - inv.getStartPrice() > 0) {
						up++;
					} else if (inv.getStopPrice() - inv.getStartPrice() < 0) {
						down++;
					}
				}
			} else {
				//价格低于
				if (inv.getStopPrice() < request.getPrice()) {
					ttl++;
					if (inv.getStopPrice() - inv.getStartPrice() > 0) {
						up++;
					} else if (inv.getStopPrice() - inv.getStartPrice() < 0) {
						down++;
					}
				}
			}
		}
		
		response.setTotleDays(ttl);
		response.setDownDays(down);
		response.setUpDays(up);
		response.setRequest(request);
		return response;
	}
}
