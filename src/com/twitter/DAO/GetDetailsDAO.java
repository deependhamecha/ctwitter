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


/** This class gets Details of User and Tweets from database using Hibernate Query Language & its methods.
 * @author Deepen Dhamecha
 *
 */
public class GetDetailsDAO {

	
	/** This method gets List of all Tweets
	 * @return List<Tweet> List of Tweet object.
	 */
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
	
	/** This method checks whether Username Exist or not
	 * @param AccountDetails AccountDetails object.
	 * @return boolean Returns true if Username exist and false if doesnt exist.
	 */
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
	
	/** This method gets List of all Tweets of a particular user
	 * @param Integer Pass accountId of AccountDetails 
	 * @return List<Tweet> List of Tweet object.
	 */
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
	
	/** Returns single Tweet by tweetId
	 * @param Integer Pass unique tweetId 
	 * @return Tweet Returns single Tweet object.
	 */
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
	
	/** This method gets AccountDetails of a particular user referred by accountId
	 * @param Integer Pass unique accountId
	 * @return AccountDetails .
	 */
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
	
	/** This method gets AccountDetails of a particular user referred by username
	 * @param username Pass unique username
	 * @return AccountDetails
	 */
	public AccountDetails getAccountDetails(String username){
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
		if(username != null){
			accountDetails = ((AccountDetails)session.createQuery("from AccountDetails where username=\'"+username+"\'").uniqueResult());
			session.getTransaction().commit();
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
			
		}
		return accountDetails;
	}

	/** This method returns no of Tweets of a particular user
	 * @param Integer accountId of a user AccountDetails
	 * @return int Returns no of Tweets of a user
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
	
	/** This method returns total no of Tweets
	 * @return int Returns no of Tweets
	 */
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
	
	/** This method returns total no of AccountDetails
	 * @return int Returns no of AccountDetails
	 */
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
	
	/** This method returns last tweetId inserted
	 * @return int Returns tweetId as int type
	 */
	public int getLastTweetId(){
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int tweetId = 0;
		
		try{
			if(this.getTotalNoOfTweets() > 0){
				tweetId = (session.createQuery("SELECT max(tweetId) FROM Tweet")) != null ? ((Integer)session.createQuery("SELECT max(tweetId) FROM Tweet").uniqueResult()).intValue(): 0;
				session.getTransaction().commit();
			}
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		return tweetId;
	}
	
	/** This method checks username and password returns Integer > 0 if it matches username and password, it returns true else -1
	 * @param String Username
	 * @param String Password 
	 * @return Integer If it Returns < 0 if not present, -1 if exception occurres, and > 1 if username and password matches with database records.
	 */
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
