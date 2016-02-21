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
	
	public boolean deleteAccountDetails(Integer accountId){
		
		boolean flag = true;
		
		AccountDetails accountDetails = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try{
			if(accountId != null){
				this.deleteAllTweets(accountId);
				
				sessionFactory = new Configuration().configure().buildSessionFactory(); 
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				
				session.delete(accountDetails);
				transaction.commit();
				
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
	
	public boolean deleteTweet(Integer tweetId, Integer accountId){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		Tweet tweet = null;
		
		try{
			if(accountId != null && tweetId != null){
				tweet = (Tweet) session.get(Tweet.class, tweetId);
				session.delete(tweet);
				session.getTransaction().commit();

				flag = true;
			}else if(tweetId == null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				
			}
			else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
}
