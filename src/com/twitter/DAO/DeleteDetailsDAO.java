package com.twitter.DAO;

import javax.persistence.criteria.CriteriaDelete;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class DeleteDetailsDAO {
	
	public boolean deleteAccountDetails(AccountDetails accountDetails){
		
		boolean flag = true;
		
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try{
			if(accountDetails.getAccountId() != null){
				
				
				sessionFactory = new Configuration().configure().buildSessionFactory(); 
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountDetails.getAccountId());
				
				session.delete(accountDetails);
				transaction.commit();
				
				this.deleteAllTweets(accountDetails.getAccountId());
				
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			transaction.rollback();
			
			flag = false;
		}finally{
			session.close();
			sessionFactory.close();
		}
		return flag;
	}
	
	public boolean deleteAllTweets(Integer accountId){
		boolean flag;
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		if(accountId != null && session !=null){
			try{
				Query query = session.createQuery("delete Tweet where accountid = :accId");
				query.setParameter("accId", accountId);
				int result = query.executeUpdate();
				
				transaction.commit();
				
				flag = true;
			}catch(Exception e){
				transaction.rollback();
				flag = false;
			}finally{
				
				session.close();
				sessionFactory.close();
			}
		}else{
			flag=false;
		}
		
		return flag;
	}
	
	public boolean deleteTweet(Integer tweetId, Tweet tweet){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try{
			if(tweet.getUsername() != null && tweetId != null){
				tweet = (Tweet) session.get(Tweet.class, tweetId);
				session.delete(tweet);
				session.getTransaction().commit();

				flag = true;
			}else if(tweetId == null && tweet.getUsername() != null){
				Query query = session.createQuery("delete Tweet where username = :username");
				query.setParameter("username", tweet.getUsername());
				int result = query.executeUpdate();
				session.getTransaction().commit();
			}
			else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		
		return flag;
	}
	
}
