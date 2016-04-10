package com.frc.investment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeIntervalUtil {
	public static int calculateTimeInterval(String from, String to) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date1 = sdf.parse(from);
			Date date2 = sdf.parse(to);
			long time = date2.getTime() - date1.getTime();
			return (int)(time/(1000 * 3600 * 24));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
