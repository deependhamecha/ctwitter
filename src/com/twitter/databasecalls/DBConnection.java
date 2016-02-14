package com.twitter.databasecalls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.twitter.model.AccountDetails;

public class DBConnection {

	public void setAccountDetails(AccountDetails accountDetails){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); // /WEB-INF/hibernate.cfg.xml
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(accountDetails);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	
}
