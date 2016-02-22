package com.twitter.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class AddDetailsDAO {

	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		if(accountDetails != null){
			
			if(!(new GetDetailsDAO().isUsernameExist(accountDetails))){
				session.save(accountDetails);
				session.getTransaction().commit();
			}else{
				return null;
			}
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
				tweet.setTweetDate(new Date());
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
