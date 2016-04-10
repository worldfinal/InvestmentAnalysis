package com.frc.investment.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.frc.investment.bean.Investment;
import com.frc.log.InvtLog;
import com.frc.utils.ReadCSVUtil;

public class DataConverterUtil {
	// 白银交易明细--每一行数据
	public Investment convertTradeDetailFromStringArray(String[] data) {
		InvtLog.enter(this, "convertFromStringArray");

		if (data == null || data.length == 0) {
			InvtLog.error(this, "No data");
			return null;
		}

		if (data.length < 8) {
			InvtLog.error(this, "Data format is invalid");
			return null;
		}
		Investment inv = new Investment();

		try {
			Date date = parseDate(data[0]);
			if (date != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
				inv.setDate(dateFormat.format(date));	// 日期
				inv.setTradeTime(timeFormat.format(date));	// 时间
			}
			
			// 开盘
			inv.setStartPrice(parseDouble(data[1]));
			// 最高
			inv.setMaxPrice(parseDouble(data[2]));
			// 最低
			inv.setMinPrice(parseDouble(data[3]));
			// 收盘
			inv.setStopPrice(parseDouble(data[4]));
			// 成交量
			inv.setVolumeOfDeal(parseDouble(data[5]));
			
			inv.setAcountOfDeal(0L);
			inv.setAmountOfDeal(0L);
			
		} catch (Exception e) {
	//		e.printStackTrace();
			InvtLog.error(this, e.getMessage());
			return null;
		}

		if (inv.getDate() == null || inv.getDate().length() == 0) {
			return null;
		}

		InvtLog.exit(this, "convertFromStringArray");
		return inv;
	}

	@Test
	public void test() {
		String path = "D:\\My Documents\\交易资料\\AGTD.csv";
		ReadCSVUtil csv = new ReadCSVUtil();
		List<String[]> datas = csv.getResultFromCSVFile(path, ReadCSVUtil.CHARAC_COMMA);
		for (int i = 2; i < datas.size(); i++) {
			Investment invt = convertTradeDetailFromStringArray(datas.get(i));
			if (invt != null) {
				System.out.println(String.format("%10s %s %f", invt.getDate(), invt.getTradeTime(), invt.getStopPrice()));
			}
		}
	}
	
	private Date parseDate(String str) throws Exception {
		InvtLog.enter(this, "parseDate");
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

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
}
