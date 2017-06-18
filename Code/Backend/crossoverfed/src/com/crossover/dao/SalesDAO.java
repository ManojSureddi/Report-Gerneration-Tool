package com.crossover.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crossover.bean.Sales;
import com.crossover.bean.SalesHelper;
import com.crossover.bean.SessionBean;
import com.crossover.utils.Encryptor;
import com.crossover.utils.SessionHelper;

public class SalesDAO {

	public SalesHelper getSalesmanData(String sessionId) {
		LinkedList<Sales> map = new LinkedList<>();
		
		SalesHelper helper= new SalesHelper();
		if(AuthDAO.checkSessionId(sessionId)){
			Sales bean = new Sales();
			Session session = SessionHelper.getHibernateSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			String hql = "Select name,SUM(value) from Sales s group by name";
			Query q = session.createSQLQuery(hql);
			List<Object[]> sadl = q.list();
			System.out.println(sadl.size());
			for (Object[] t2 : sadl) {
				bean = new Sales();
				bean.setName((String)t2[0]);
				bean.setValue((Double)t2[1]);
				map.add(bean);
				
			}
			helper.setRequestDescription("Success");		
			System.out.println(map.get(0).getName());;
			LinkedList<Object[]> dat= new LinkedList<>();
			for (Sales b:map) {		
				Object[] a= new Object[2];
				a[0]=b.getName();
				a[1]=b.getValue();
				dat.add(a);
			}

			helper.setData(dat);
		}else{
			helper.setRequestDescription("User is not logged in");
			helper.setData(null);
		}
		
		return helper;
	}

	public SalesHelper getLastYearData(String sessionId) {
		// TODO Auto-generated method stub
		String [] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Sep","Oct","Nov","Dec"};
		LinkedList<Sales> map = new LinkedList<>();	
		
		SalesHelper helper= new SalesHelper();
		if(AuthDAO.checkSessionId(sessionId)){
			Sales bean = new Sales();
			Session session = SessionHelper.getHibernateSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			String hql = "SELECT MONTH( dateoforder ) , SUM( value ) FROM sales GROUP BY MONTH( dateoforder ) ORDER BY MONTH( dateoforder ) ";
			Query q = session.createSQLQuery(hql);
			List<Object[]> sadl = q.list();
			System.out.println(sadl.size());
			for (Object[] t2 : sadl) {
				bean = new Sales();
				bean.setName(months[(Integer)t2[0]]);
				bean.setValue((Double)t2[1]);
				map.add(bean);
				
			}
			
			helper.setRequestDescription("Success");		
			System.out.println(map.get(0).getName());;
			LinkedList<Object[]> dat= new LinkedList<>();
			for (Sales b:map) {		
				Object[] a= new Object[2];
				a[0]=b.getName();
				a[1]=b.getValue();
				dat.add(a);
			}

			helper.setData(dat);
		}else{
			helper.setRequestDescription("User is not logged in");
			helper.setData(null);
		}

		return helper;
		
	}

	public SalesHelper getTopSalesOrder(String sessionId) {
		LinkedList<Sales>map= new LinkedList<>();
		SalesHelper helper= new SalesHelper();
		if(AuthDAO.checkSessionId(sessionId)){
			Sales bean = new Sales();
			Session session = SessionHelper.getHibernateSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			String hql = "SELECT name,value FROM sales ORDER BY value desc limit 5";
			Query q = session.createSQLQuery(hql);
			List<Object[]> sadl = q.list();
			System.out.println(sadl.size());
			for (Object[] t2 : sadl) {
				bean = new Sales();
				bean.setName((String)t2[0]);
				bean.setValue(Double.parseDouble((String)t2[1]));
				map.add(bean);	
			}
			
			helper.setRequestDescription("Success");		
			System.out.println(map.get(0).getName());;
			LinkedList<Object[]> dat= new LinkedList<>();
			int count=1;
			for (Sales b:map) {		
				Object[] a= new Object[2];
				a[0]=count++;
				a[1]=b.getValue();
				dat.add(a);
			}

			helper.setData(dat);
		}else{
			helper.setRequestDescription("User is not logged in");
			helper.setData(null);
		}

		return helper;
	}

	public SalesHelper getTopSalesman(String sessionId) {
		LinkedList<Sales> map = new LinkedList<>();	
		SalesHelper helper= new SalesHelper();
		if(AuthDAO.checkSessionId(sessionId)){
			Sales bean = new Sales();
			Session session = SessionHelper.getHibernateSession();
			Transaction tx = session.getTransaction();
			session.beginTransaction();
			String hql = "SELECT name,sum(value) as totalsum from sales where MONTH(curdate())-Month(dateoforder)<=3 group by name order by totalsum desc limit 5";
			Query q = session.createSQLQuery(hql);
			List<Object[]> sadl = q.list();
			System.out.println(sadl.size());
			for (Object[] t2 : sadl) {
				bean = new Sales();
				bean.setName((String)t2[0]);
				try{
				bean.setValue(((BigInteger)t2[1]).doubleValue());
				}catch(Exception e){
					bean.setValue((Double)t2[1]);
				}
				map.add(bean);		
			}		
			helper.setRequestDescription("Success");		
			System.out.println(map.get(0).getName());;
			LinkedList<Object[]> dat= new LinkedList<>();
			for (Sales b:map) {		
				Object[] a= new Object[2];
				a[0]=b.getName();
				a[1]=b.getValue();
				dat.add(a);
			}

			helper.setData(dat);
		}else{
			helper.setRequestDescription("User is not logged in");
			helper.setData(null);
		}

		return helper;
	}
	
}
