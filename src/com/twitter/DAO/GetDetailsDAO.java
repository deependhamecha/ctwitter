package com.twitter.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class GetDetailsDAO {

	public List<Tweet> getAllTweets(){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Tweet> tweetList = new ArrayList<Tweet>();
		
		try{
			
			Criteria cr = session.createCriteria(Tweet.class);
			cr.add(Restrictions.lt("tweetId", (this.getLastTweetId()+1)));
			cr.addOrder(Order.desc("tweetId"));
			tweetList = cr.list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		return tweetList;
	}
	
	public boolean isUsernameExist(AccountDetails accountDetails){
		boolean flag = false;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
			try{
				Criteria cr = session.createCriteria(AccountDetails.class);
				cr.add(Restrictions.eq("username", accountDetails.getUsername()));
				List<AccountDetails> results = (List<AccountDetails>) cr.list();
				
				if(results.size() > 0){
					flag = true;
				}else{
					flag = false;
				}
			}catch(Exception e){
				flag = false;
				e.printStackTrace();
			}finally{
				session.close();
				sessionFactory.close();
			}
		return flag;
	}
	
	public List<Tweet> getUserTweets(Integer accountId){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Tweet> tweetList = new ArrayList<Tweet>();
		
		try{
			Criteria cr = session.createCriteria(Tweet.class);
			cr.add(Restrictions.eq("accountId", accountId));
			tweetList = cr.list();
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		return tweetList;
	}
	
	
	public Tweet getTweet(Integer tweetId){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Tweet tweet = null;
		
		if(session.get(Tweet.class, tweetId) != null){
			tweet = (Tweet) session.get(Tweet.class, tweetId);
			session.getTransaction().commit();
		}
		
		session.close();
		sessionFactory.close();
		
		return tweet;
	}
	
	public AccountDetails getAccountDetails(Integer accountId){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		if(session.get(AccountDetails.class, accountId) != null){
			accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
			session.getTransaction().commit();
		}
		
		session.close();
		sessionFactory.close();
		
		return accountDetails;
	}
	
/*	public Integer getAccountIdOfTweetId(Integer tweetId){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Tweet tweet = null;
		String username = null;
		
		try{
			if(tweetId != null && session.get(Tweet.class, tweetId) != null){
				tweet = (Tweet) session.get(Tweet.class,tweetId);
				session.getTransaction().commit();
				
				if(tweet.getUsername() != null){
					username = tweet.getUsername();
				}
			}
		}catch(Exception e){
			
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		return accountId;
	}
	*/
	public int getNoOfUserTweets(Integer accountId){
	
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int count = 0;
		
		try{
			if(accountId != null){
				count = ((Long) session.createQuery("select count(*) from Tweet where accountId=\'"+accountId+"\'").uniqueResult()).intValue();
				session.getTransaction().commit();
			}
			}catch(Exception e){
				count = -1;
			}
			
		session.close();
		sessionFactory.close();
		
		return count;
	}
	
	public int getTotalNoOfTweets(){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int count = 0;
		
		try{	
			count = ((Long) session.createQuery("select count(*) from Tweet").uniqueResult()).intValue();
			session.getTransaction().commit();
			
		}catch(Exception e){
			count = -1;
		}
			
		session.close();
		sessionFactory.close();
		
		return count;
	}
	
	public int getTotalNoOfAccountDetails(){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int count = 0;
		
		try{
			count = ((Long) session.createQuery("select count(*) from AccountDetails").uniqueResult()).intValue();
			session.getTransaction().commit();
			
		}catch(Exception e){
			count = -1;
		}
			
		session.close();
		sessionFactory.close();
		
		return count;
	}
	
	public int getLastTweetId(){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int tweetId = 0;
		
		try{
			tweetId = ((Integer)session.createQuery("SELECT max(tweetId) FROM Tweet").uniqueResult()).intValue();;
			session.getTransaction().commit();
			
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		return tweetId;
	}
	
	public Integer checkCredentials(String username, String password){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
			Criteria cr = session.createCriteria(AccountDetails.class);
			cr.add(Restrictions.eq("username", username));
			cr.add(Restrictions.eq("password", password));
			List<AccountDetails> results = (List<AccountDetails>) cr.list();
			transaction.commit();
			
			if(results.size() > 0){
				
				return results.get(0).getAccountId();
				
			}else{
				return -1;
			}
			
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return -1;
		}finally{
			session.close();
			sessionFactory.close();
		}
		
	}
	
}
