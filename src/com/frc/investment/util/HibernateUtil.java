package com.frc.investment.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.frc.investment.bean.Investment;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration conf = new Configuration();
			conf.configure();
			ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
					conf.getProperties()).buildServiceRegistry();

			sessionFactory = conf.buildSessionFactory(sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String date = "1986/11/03";

		Investment inv = new Investment();
		inv.setAcountOfDeal(1232L);
		inv.setAmountOfDeal(12323L);
		inv.setDate(date);
		inv.setMaxPrice(3609);
		inv.setMinPrice(3522);
		inv.setStartPrice(3592);
		inv.setStopPrice(3604);
		inv.setType("AGTD");
		inv.setVolumeOfDeal(77884333.23);

		try {
			HibernateUtil.save(inv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		List<Investment> list = null;
		try {
			list = HibernateUtil.listUsers();
			System.out.println("list.size()=" + list.size());
			for (int i = 0; i < list.size(); i++) {
				Investment inv = list.get(i);
				System.out.println(inv.getMinPrice() + "," + inv.getMaxPrice() + "," + inv.getStopPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void save(Investment inves) throws Exception {
		Transaction tr = null;
		Session session = sessionFactory.openSession();

		try {
			tr = session.beginTransaction();
			// tr.begin();
			session.save(inves);
			tr.commit();
		} catch (Exception e) {
			if (null != tr) {
				tr.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Investment> listUsers() throws Exception {
		List<Investment> list = null;
		Transaction tr = null;
		Session session = sessionFactory.openSession();

		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from Investment";
			Query query = session.createQuery(sql);

			list = (List<Investment>) query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
}
