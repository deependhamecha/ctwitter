package com.twitter.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class AddDetailsDAO {

	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		if(accountDetails != null){
			session.save(accountDetails);
			session.getTransaction().commit();
		}
		
		session.close();
		sessionFactory.close();
	
		return accountDetails;
	}
	
	public Tweet addTweet(Tweet tweet){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
		if(tweet != null){
			session.save(tweet);
			session.getTransaction().commit();
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		return tweet;
		
	}
}
