package com.frc.investment.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.frc.investment.bean.Investment;
import com.frc.log.InvtLog;

@Service("InvestmentService")
public class InvestmentService {
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	
	public int saveInvestment(String type, List<Investment> list) {
		InvtLog.enter(this, "saveInvestment");
		
		Transaction tr = null;
		Session session = null;
		session = sessionFactory.openSession();
		
		List dateArray = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
		//	dateArray[i] = sdf.format(list.get(i).getDate());
			if (list.get(i).getDate() != null) {
				dateArray.add(list.get(i).getDate());
			}
		}

		String sql = "from Investment inv where inv.type = :type and inv.date in (:dateList) ";
		
		Query query = session.createQuery(sql);
		query.setString("type", type);
		query.setParameterList("dateList", dateArray);
		List<Investment> updateList = query.list();
		InvtLog.info(this,
				String.format("updateList.size() = %d", updateList.size()));

		try {
			tr = session.beginTransaction();
			
			int saveCount = 0;
			for (int i = 0; i < updateList.size(); i++) {
				Investment invt = updateList.get(i);
				session.update(invt);
			}
			
			for (int i = 0; i < list.size(); i++) {
				Investment invt = list.get(i);
				Investment obj = null;
				boolean add = true;
				for (int j = 0; j < updateList.size(); j++) {
					obj = updateList.get(j);
					if (invt.getDate().equals(obj.getDate())) {
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
					obj.setMaxPrice(invt.getMaxPrice());
					obj.setMinPrice(invt.getMinPrice());
					obj.setStartPrice(invt.getStartPrice());
					obj.setStopPrice(invt.getStopPrice());
					obj.setType(type);
					obj.setVolumeOfDeal(invt.getVolumeOfDeal());
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
	
	public List<Investment> retrieveInvestment(String type) {
		InvtLog.enter(this, "retrieveInvestment");
		List<Investment> result = new ArrayList<Investment>();
		
		Transaction tr = null;
		Session session = null;
		session = sessionFactory.openSession();

		try {
			tr = session.beginTransaction();
			
			String sql = "from Investment where type = ?";
			Query query = session.createQuery(sql);
			query.setString(0, type);
			result = query.list();
			
			tr.commit();
		} catch (Exception e) {
			if (null != tr) {
				tr.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		
		InvtLog.exit(this, "retrieveInvestment");
		return result;
	}
	
	public List<Investment> retrieveInvestment(String fromDate, String toDate, String type) {
		InvtLog.enter(this, "retrieveInvestment");
		List<Investment> result = new ArrayList<Investment>();
		
		Transaction tr = null;
		Session session = null;
		session = sessionFactory.openSession();

		try {
			tr = session.beginTransaction();
			
			String sql = "from Investment invt where invt.type = ? and invt.date >= ? and invt.date <= ? order by invt.date";
			Query query = session.createQuery(sql);
			query.setString(0, type);
			query.setString(1, fromDate);
			query.setString(2, toDate);
			result = query.list();
			
			tr.commit();
		} catch (Exception e) {
			if (null != tr) {
				tr.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		
		InvtLog.exit(this, "retrieveInvestment");
		return result;
	}
	
}
