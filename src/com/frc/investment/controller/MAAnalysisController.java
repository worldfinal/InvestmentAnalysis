package com.frc.investment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frc.investment.bean.Investment;
import com.frc.investment.model.MARequest;
import com.frc.investment.model.MAResponse;
import com.frc.investment.model.MAResult;
import com.frc.investment.service.InvestmentService;
import com.frc.investment.util.TimeIntervalUtil;
import com.frc.log.InvtLog;

@Controller
@RequestMapping("/analysis")
public class MAAnalysisController {
	@Resource(name="InvestmentService")
	private InvestmentService investmentService = null;
	
	@RequestMapping(value="/ma", method = RequestMethod.POST)
	public @ResponseBody MAResponse
	retrieveResult(@RequestBody MARequest request) {
		MAResponse response = new MAResponse();
		response.setRequest(request);
		response.setTrades(new ArrayList<MAResult>());
		
		List<Investment> investmentList = investmentService.retrieveInvestment(
				request.getFromDate(), request.getToDate(), request.getType());
		
		double MAs[][] = new double[5][];
		/* 计算
		 * MA1 （5天）
		 * MA2 （10天）
		 * MA3 （20天）
		 * MA4 （30天）
		 * MA5 （60天）
		 */
		MAs[0] = calculateMA(5, investmentList);
		MAs[1] = calculateMA(10, investmentList);
		MAs[2] = calculateMA(20, investmentList);
		MAs[3] = calculateMA(30, investmentList);
		MAs[4] = calculateMA(60, investmentList);
		
		List<MAResult> list = null;
		String param = request.getParam();
		if ("1".equals(param)) {
			list = calculateResult1(investmentList, MAs);
		} else if ("3".equals(param)) {
			list = calculateResult3(investmentList, MAs);
		} else if ("5".equals(param)) {
			list = calculateResult5(investmentList, MAs);
		}
		 
		updateMAResultList(list, investmentList, request);
		
		response.setTrades(list);
		return response;
	}
	
	private void updateMAResultList(List<MAResult> MAresultList, List<Investment> list, MARequest request) {
		if (MAresultList == null || list == null) {
			return;
		}
		int pos = 0;
		for (int i = 0; i < MAresultList.size(); i++) {
			MAResult ma = MAresultList.get(i);
			pos = 0;
			while (pos < list.size()) {
				Investment invt = list.get(pos);
				if (invt.getDate().equals(ma.getInDate())) {
					ma.setMinPrice(invt.getMinPrice());
					ma.setMaxPrice(invt.getMaxPrice());
					ma.setInPrice((invt.getMinPrice() + invt.getMaxPrice())/2);
					break;
				}
				pos++;
			}
			for (int j = pos + 1; j < list.size(); j++) {
				Investment invt = list.get(j);
				if ("0".equals(request.getOperation())) {	//BUY
					if (invt.getMaxPrice() - ma.getInPrice() >= request.getEarn()) {
						ma.setOutDate(invt.getDate());
						int days = TimeIntervalUtil.calculateTimeInterval(ma.getInDate(), ma.getOutDate());
						ma.setLastDays(days);
					}
				} else {
					if (ma.getInPrice() - invt.getMinPrice() >= request.getEarn()) {
						ma.setOutDate(invt.getDate());
						int days = TimeIntervalUtil.calculateTimeInterval(ma.getInDate(), ma.getOutDate());
						ma.setLastDays(days);
					}
				}
			}
			MAresultList.set(i, ma);
		}
	}
	
	//	MA1上穿MA2,MA3,MA4,MA5之后买入，赚{多少}之后平仓
	private List<MAResult> calculateResult1(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		double[] MA3 = MAs[2];
		double[] MA4 = MAs[3];
		double[] MA5 = MAs[4];
		
		int ma2pos, ma3pos, ma4pos, ma5pos;
		for (int i = 3; i < MA1.length; i++) {
			//保证MA1处于上升
			if (!isRaising(MA1, i, 3)) {
				continue;
			}
			if (MA1[i] > MA2[i] || MA1[i] > MA3[i] || MA1[i] > MA4[i] || MA1[i] > MA5[i]) {
				continue;
			}
			ma2pos = ma3pos = ma4pos = ma5pos = i;
			for (int j = i + 1; j < MA1.length; j++) {
				if (ma2pos != i && ma3pos != i && ma4pos != i && ma5pos != i) {
					break;
				}
				if (ma2pos == i) {
					if (MA1[j] > MA2[j]) {
						ma2pos = j;
					}
				}
				if (ma3pos == i) {
					if (MA1[j] > MA3[j]) {
						ma3pos = j;
					}
				}
				if (ma4pos == i) {
					if (MA1[j] > MA4[j]) {
						ma4pos = j;
					}
				}
				if (ma5pos == i) {
					if (MA1[j] > MA5[j]) {
						ma5pos = j;
					}
				}
			}
			if (ma2pos != i && ma3pos != i && ma4pos != i && ma5pos != i) {
				if (ma2pos - i < 3 &&
					ma3pos - i < 6 &&
					ma4pos - i < 9 &&
					ma5pos - i < 15) {
					Investment invt = list.get(i);
					MAResult maResult = new MAResult();
					maResult.setInDate(invt.getDate());
					rs.add(maResult);
				}
			}
		}
		return rs;
	}
	
	private List<MAResult> calculateResult2(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		double[] MA3 = MAs[2];
		double[] MA4 = MAs[3];
		double[] MA5 = MAs[4];
		
		return rs;
	}
	
	private List<MAResult> calculateResult3(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		double[] MA3 = MAs[2];
		
		int ma2pos, ma3pos;
		for (int i = 3; i < MA1.length; i++) {
			//保证MA1处于上升
			if (!isRaising(MA1, i, 3)) {
				continue;
			}
			if (MA1[i] > MA2[i] || MA1[i] > MA3[i] ) {
				continue;
			}
			ma2pos = ma3pos = i;
			for (int j = i + 1; j < MA1.length; j++) {
				if (ma2pos != i && ma3pos != i) {
					break;
				}
				if (ma2pos == i) {
					if (MA1[j] > MA2[j]) {
						ma2pos = j;
					}
				}
				if (ma3pos == i) {
					if (MA1[j] > MA3[j]) {
						ma3pos = j;
					}
				}
			}
			if (ma2pos != i && ma3pos != i) {
				if (ma2pos - i < 3 &&
					ma3pos - i < 6
					) {
					Investment invt = list.get(i);
					MAResult maResult = new MAResult();
					maResult.setInDate(invt.getDate());
					rs.add(maResult);
				}
			}
		}
		return rs;
	}
	
	private List<MAResult> calculateResult4(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		double[] MA3 = MAs[2];
		double[] MA4 = MAs[3];
		double[] MA5 = MAs[4];
		
		return rs;
	}
	
	private List<MAResult> calculateResult5(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		
		int ma2pos;
		for (int i = 3; i < MA1.length; i++) {
			//保证MA1处于上升
			if (!isRaising(MA1, i, 3)) {
				continue;
			}
			if (MA1[i] > MA2[i]) {
				continue;
			}
			ma2pos = i;
			for (int j = i + 1; j < MA1.length; j++) {
				if (ma2pos != i) {
					break;
				}
				if (ma2pos == i) {
					if (MA1[j] > MA2[j]) {
						ma2pos = j;
					}
				}
			}
			if (ma2pos != i) {
				if (ma2pos - i < 3) {
					Investment invt = list.get(i);
					MAResult maResult = new MAResult();
					maResult.setInDate(invt.getDate());
					rs.add(maResult);
				}
			}
		}
		return rs;
	}
	
	private List<MAResult> calculateResult6(List<Investment> list, double[][] MAs) {
		List rs = new ArrayList<MAResult>();
		double[] MA1 = MAs[0];
		double[] MA2 = MAs[1];
		double[] MA3 = MAs[2];
		double[] MA4 = MAs[3];
		double[] MA5 = MAs[4];
		
		return rs;
	}
		
	private double[] calculateMA(int n, List<Investment> list) {
		double[] rs = new double[list.size()];
		
		double sum = 0.0;
		//前i个的MA值就等于前i个的平均值(i<n)
		for (int i = 0; i < n; i++) {
			Investment inv = list.get(i);
			sum += inv.getStopPrice();
			rs[i] = (sum / (double)(i+1));
		}
		
		//从第n开始
		for (int i = n; i < list.size(); i++) {
			Investment inv = list.get(i);
			sum += inv.getStopPrice() - list.get(i-n).getStopPrice();
			rs[i] = (sum / (double)(n));
		}
		
		return rs;
	}
	
	//data[idx]的位置之前，是否出现连续m次上升
	private boolean isRaising(double[] data, int idx, int m) {
		if (data == null || idx >= data.length) {
			InvtLog.error(this, String.format(
					"[MAAnalysisController.isRaising] data=%s, idx=%d, m=%d",
					data, idx, m));			
			return false;
		}
		
		if (m <= 0 || m >= 30) {
			InvtLog.error(this, String.format("[MAAnalysisController.isRaising] invalid m (%d)", m));
			return false;
		}
		
		if (idx - m < 0) {
			return false;
		}
		
		for (int i = 1; i <= m; i++) {
			if (data[idx-i] > data[idx-i+1]) {
				return false;
			}
		}
		
		return true;
	}
	
	//data[idx]的位置之前，是否出现连续m次下跌
	private boolean isReducing(double[] data, int idx, int m) {
		if (data == null || idx >= data.length) {
			InvtLog.error(this, String.format(
					"[MAAnalysisController.isRaising] data=%s, idx=%d, m=%d",
					data, idx, m));
			return false;
		}

		if (m <= 0 || m >= 30) {
			InvtLog.error(this, String.format(
					"[MAAnalysisController.isRaising] invalid m (%d)", m));
			return false;
		}

		if (idx - m < 0) {
			return false;
		}

		for (int i = 1; i <= m; i++) {
			if (data[idx - i] < data[idx - i + 1]) {
				return false;
			}
		}

		return true;
	}
	
	@RequestMapping(value = "/matest")
	@ResponseBody
	public String test() {
		int n = 5;//MA5
		List<Investment> result = investmentService.retrieveInvestment("2013/01/01", "2015/02/09", "AGTD");
		if (result.size() <= 5) {
			return "Fail";
		}
		
		String rs = "";
		double curSum = 0.0;
		for (int i = 0; i < result.size() && i < n; i++) {
			Investment inv = result.get(i);
			curSum += inv.getStopPrice();
		}
		for (int i = n; i < result.size(); i++) {
			Investment inv = result.get(i);
			curSum += inv.getStopPrice()-result.get(i - n).getStopPrice();
			String out = String.format("[%s] %.4f", inv.getDate(), curSum / (double)n);
			rs += out + "\r\n";
			System.out.println(out);
		}		
		return rs;
	}
	
	
}
