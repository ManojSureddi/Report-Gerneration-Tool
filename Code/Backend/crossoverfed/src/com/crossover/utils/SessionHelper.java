package com.crossover.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionHelper {

	static private SessionFactory sessionFactory = null;

	public static Session getHibernateSession() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registerBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registerBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		System.out.println("inside session helper");
		return session;

	}

	public static void closeSession(Session session) {
		session.close();
		System.out.println("session closed");
	}

	public static void main(String args[]) {
		SessionHelper obj = new SessionHelper();
		System.out.println(SessionHelper.getHibernateSession());
	}

}
