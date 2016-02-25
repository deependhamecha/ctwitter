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

/** This class Deletes records from database
 * @author Deepen Dhamecha
 *
 */
public class DeleteDetailsDAO {
	
	/** Deletes AccountDetails and return true if successfully deleted and false if not.
	 * @param accountDetails AccountDetails but internally deletes by accountId of this class so always set accountId to this object while passing.
	 * @return flag Returns true if successful and false if not. 
	 */
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
	
	/** Deletes All Tweets and return true if successfully deleted and false if not.
	 * @param accountId Deletes all Tweets of a user using accountId 
	 * @return flag Returns true if successful and false if not. 
	 */
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
	
	/** Deletes Tweet and return true if successfully deleted and false if not.
	 * @param tweet Tweet but internally deletes by tweetId of this class so always set tweetId to this object while passing.
	 * @return flag Returns true if successful and false if not. 
	 */
	public boolean deleteTweet(Tweet tweet){
		
		boolean flag = false;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try{
			if(tweet.getTweetId() != null){
				Query query = session.createQuery("delete Tweet where tweetId = :tweetId");
				query.setParameter("tweetId", tweet.getTweetId());
				int result = query.executeUpdate();
				session.getTransaction().commit();
				flag = true;
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
