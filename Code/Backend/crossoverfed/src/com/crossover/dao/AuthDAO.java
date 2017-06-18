package com.crossover.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crossover.bean.SessionBean;
import com.crossover.bean.User;
import com.crossover.utils.Encryptor;
import com.crossover.utils.SessionHelper;


public class AuthDAO {

	public SessionBean getUserSession(String uname, String pass) {
		Session session = SessionHelper.getHibernateSession();
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		String hql = "from User u where u.username=:param and password=:pass";
		Query q = session.createQuery(hql);
		q.setString("param", uname);
		q.setString("pass", pass);
		List l = q.list();
		if(l.size()==1){
			SessionBean bean= new SessionBean();
			bean.setSessionId(Encryptor.encryptData("uname"+"pass"+Math.random()));
			bean.setLoginSucceeded(true);
			User obj= (User)l.get(0);
			obj.setSessionId(bean.getSessionId());
			tx.commit();
			session.close();
			return bean;
		}else{
			SessionBean bean= new SessionBean();
			bean.setSessionId("");
			bean.setLoginSucceeded(false);
			tx.commit();
			session.close();
			return bean;	
		}
		
	}
	public String logout(String sessionId){
		System.out.println(sessionId);
		Session session = SessionHelper.getHibernateSession();
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		String hql = "from User u where  u.sessionId=:sessionId";
		Query q = session.createQuery(hql);
		q.setString("sessionId", sessionId);
		List l = q.list();

		if(l.size()==1){
			User obj= (User)l.get(0);
			obj.setSessionId("");
			tx.commit();
			session.close();
		}
		tx.commit();
		session.close();
		return "success";
	}
	public static boolean checkSessionId(String sessionId){
		System.out.println(sessionId);
		Session session = SessionHelper.getHibernateSession();
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		String hql = "from User u where  u.sessionId=:sessionId";
		Query q = session.createQuery(hql);
		q.setString("sessionId", sessionId);
		List l = q.list();
		tx.commit();
		session.close();
		if(l.size()==1){
			
			return true;
		}else{
			return false;
		}
		
	}
	public User getUserDetails(String sessionId){
		System.out.println(sessionId);
		Session session = SessionHelper.getHibernateSession();
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		String hql = "from User u where  u.sessionId=:sessionId";
		Query q = session.createQuery(hql);
		q.setString("sessionId", sessionId);
		List l = q.list();
		tx.commit();
		session.close();
		System.out.println(l.size());
		if(l.size()==1){
			User u=(User)l.get(0);
			return u;
		}else{
			return null;
		}
		
	}

}
