package com.frc.investment.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.frc.investment.bean.Investment;
import com.frc.investment.model.InvestmentModel;
import com.frc.log.InvtLog;
import com.frc.utils.ReadCSVUtil;

public class InvestmentConverterService {
	
	public List<InvestmentModel> convertToModel(List<Investment> list) {
		InvtLog.enter(this, "convertToModel");
		List<InvestmentModel> result = new ArrayList<InvestmentModel>();
		
		for (int i = 0; i < list.size(); i++) {
			Investment invt = list.get(i);
			Date date = null;
			try {
				date = parseDate(invt.getDate());
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
					
			InvestmentModel model = new InvestmentModel(
					invt.getDate(),
					date.getYear() + 1900,
					date.getMonth() + 1,
					date.getDate(),
					invt.getStartPrice(),
					invt.getStopPrice(),
					invt.getMinPrice(),
					invt.getMaxPrice(),
					invt.getVolumeOfDeal(),
					invt.getAmountOfDeal(),
					invt.getAcountOfDeal(),
					invt.getType());
			result.add(model);
		}
		
		InvtLog.exit(this, "convertToModel");
		return result;
	}
	
	//白银交易明细表 -- 转换为对象数组
	public List<Investment> convertTradeDetailFromRaw(List<String[]>data) {
		InvtLog.enter(this, "convertTradeDetailFromRaw");
		
		List<Investment> result = new ArrayList<Investment>();
		for (int i = 0; i < data.size(); i++) {
			Investment inv = convertTradeDetailFromStringArray(data.get(i));
			if (inv != null) {
				result.add(inv);
			}
		}
		
		InvtLog.exit(this, "convertTradeDetailFromRaw");
		return result;
	}
	
	//白银交易明细--每一行数据
	public Investment convertTradeDetailFromStringArray(String[] data) {
		InvtLog.enter(this, "convertFromStringArray");
		
		if (data == null || data.length == 0) {
			InvtLog.error(this, "No data");
			return null;
		}
		
		if (data.length < 13) {
			InvtLog.error(this, "Data format is invalid");
			return null;
		}
		Investment inv = new Investment();
		
		try {
			//日期
			inv.setDate(data[0]);
			//开盘
			inv.setStartPrice(parseDouble(data[1]));			
			//最高
			inv.setMaxPrice(parseDouble(data[2]));			
			//最低
			inv.setMinPrice(parseDouble(data[3]));			
			//收盘
			inv.setStopPrice(parseDouble(data[4]));			
			//成交量
			inv.setVolumeOfDeal(parseDouble(data[5]));			
			//成交额
			inv.setAcountOfDeal(parseLong(data[6]));			
			//成交笔数
			inv.setAmountOfDeal(parseLong(data[7]));
		} catch (Exception e) {
			e.printStackTrace();
			InvtLog.error(this, e.getMessage());
			return null;
		}
		
		if (inv.getDate() == null || inv.getDate().length() == 0) {
			return null;
		}
		
		
		InvtLog.exit(this, "convertFromStringArray");
		return inv;
	}
	
	private Date parseDate(String str) throws Exception{
		InvtLog.enter(this, "parseDate");
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		date = sdf.parse(str);
		
		InvtLog.exit(this, "parseDate");
		return date;
	}
	
	private double parseDouble(String str) {
		InvtLog.enter(this, "parseDouble");
		
		double rt = 0.0;
		rt = Double.parseDouble(str);
		
		InvtLog.exit(this, "parseDouble");
		return rt;
	}
	
	private long parseLong(String str) {
		InvtLog.enter(this, "parseLong");
		
		long rt = 0L;
		rt = Long.parseLong(str);
		
		InvtLog.exit(this, "parseLong");
		return rt;
	}
	
	@Test
	public void test() {
		String fileName = "D:\\My Documents\\交易资料\\agtd.txt";
		ReadCSVUtil csv = new ReadCSVUtil();
		List<String[]> rs = csv.getResultFromCSVFile(fileName, ReadCSVUtil.CHARAC_TAB);
		List<Investment> result = convertTradeDetailFromRaw(rs);
		System.out.println(result.size());
	}
}
