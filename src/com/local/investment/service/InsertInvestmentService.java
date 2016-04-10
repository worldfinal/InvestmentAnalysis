package com.local.investment.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.frc.investment.bean.Investment;
import com.frc.investment.util.DataConverterUtil;
import com.frc.log.InvtLog;
import com.frc.utils.ReadCSVUtil;

public class InsertInvestmentService {
	private static final SessionFactory sessionFactory;
	
	static
    {
        try
        {
            Configuration config = new Configuration().configure("/hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        }
        catch(Throwable e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }
	
	@Test
	public void saveData() {
		String type = "DJIA";
		String interval = "5MIN";
		List<Investment> list = new ArrayList<Investment>();
		String path = "D:\\My Documents\\交易资料\\AGTD.csv";
		ReadCSVUtil csv = new ReadCSVUtil();
		DataConverterUtil convertor = new DataConverterUtil();
		List<String[]> datas = csv.getResultFromCSVFile(path, ReadCSVUtil.CHARAC_COMMA);
		for (int i = 2; i < datas.size(); i++) {
			Investment invt = convertor.convertTradeDetailFromStringArray(datas.get(i));
			invt.setType(type);
			invt.setDataInterval(interval);
			if (invt != null) {
				list.add(invt);
				System.out.println(String.format("%10s %s %f", invt.getDate(), invt.getTradeTime(), invt.getStopPrice()));
			}
		}
		saveInvestment(type, list);
	}
	
	public int saveInvestment(String type, List<Investment> list) {
		InvtLog.enter(this, "saveInvestment");
		
		Transaction tr = null;
		Session session = null;
		session = sessionFactory.openSession();
		
		List dateArray = new ArrayList<String>();
		List timeArray = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
		//	dateArray[i] = sdf.format(list.get(i).getDate());
			if (list.get(i).getDate() != null) {
				dateArray.add(list.get(i).getDate());
				timeArray.add(list.get(i).getTradeTime());
			}
		}

		String sql = "from Investment inv where inv.type = :type and inv.date in (:dateList) and inv.tradeTime in (:timeList)";
		
		Query query = session.createQuery(sql);
		query.setString("type", type);
		query.setParameterList("dateList", dateArray);
		query.setParameterList("timeList", timeArray);
		List<Investment> updateList = query.list();
		InvtLog.info(this,
				String.format("updateList.size() = %d", updateList.size()));

		try {
			tr = session.beginTransaction();
			
			int saveCount = 0;
			
			for (int i = 0; i < list.size(); i++) {
				Investment invt = list.get(i);
				Investment obj = null;
				boolean add = true;
				for (int j = 0; j < updateList.size(); j++) {
					obj = updateList.get(j);
					if (invt.getDate().equals(obj.getDate()) && invt.getTradeTime().equals(obj.getTradeTime())) {
						add = false;
						break;
					}
				}
				if (add) {
					saveCount++;
					invt.setType(type);
					session.save(invt);
				} else {
					obj.setAcountOfDeal(invt.getAcountOfDeal());
					obj.setAmountOfDeal(invt.getAmountOfDeal());
					obj.setDate(invt.getDate());
					obj.setTradeTime(invt.getTradeTime());
					obj.setMaxPrice(invt.getMaxPrice());
					obj.setMinPrice(invt.getMinPrice());
					obj.setStartPrice(invt.getStartPrice());
					obj.setStopPrice(invt.getStopPrice());
					obj.setType(type);
					obj.setVolumeOfDeal(invt.getVolumeOfDeal());
					obj.setDataInterval(invt.getDataInterval());
					session.update(obj);
				}
			}
			
			System.out.println("Save count: " + saveCount);
			System.out.println("update count:" + updateList.size());
			
			tr.commit();
		} catch (Exception e) {
			if (null != tr) {
				tr.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		
		InvtLog.exit(this, "saveInvestment");
		return 0;
	}
}
