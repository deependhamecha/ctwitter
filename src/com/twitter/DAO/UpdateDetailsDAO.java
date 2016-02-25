package com.twitter.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/** This class Updates Details of AccountDetails and Tweet
 * @author Deepen Dhamecha
 *
 */
public class UpdateDetailsDAO {

	/** Updates Name of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param name Name of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updateName(Integer accountId, String name){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(name != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setName(name);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
				}
			}catch(Exception e){
				flag = false;
			}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Email Address of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param emailAddress Email Address of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updateEmailAddress(Integer accountId, String emailAddress){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(emailAddress != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setEmailAddress(emailAddress);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
				}
			}catch(Exception e){
				flag = false;
			}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Profile Pic URL of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param profilePic Profile Pic of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updateProfilePic(Integer accountId, String profilePic){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(profilePic != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setProfilePic(profilePic);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Status of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param status Status of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updateStatus(Integer accountId, String status){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(status != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setStatus(status);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Username of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param username Username of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updateUsername(Integer accountId, String username){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(username != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setUsername(username);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Password of User using accountId
	 * @param accountId Unique accountId of a user
	 * @param password Password of a user
	 * @return Returns true if successful and false if not.
	 */
	public boolean updatePassword(Integer accountId, String password){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		AccountDetails accountDetails = null;
		
		try{
			if(password != null && accountId != null){
				accountDetails = (AccountDetails) session.get(AccountDetails.class, accountId);
				accountDetails.setPassword(password);
				session.update(accountDetails);
				session.getTransaction().commit();
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			flag = false;
		}
		
		
		session.close();
		sessionFactory.close();
		
		return flag;
	}
	
	/** Updates Tweet of User using tweetId
	 * @param tweettId Unique accountId of a user
	 * @param tweetMessage tweetMessage of a user by passing Tweet object.
	 * @return Returns true if successful and false if not.
	 */
	public Tweet updateTweetMessage(Tweet tweet){

		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try{
			if(tweet.getTweetMessage() != null && tweet.getTweetId() != null){
				tweet.setTweetDate(new Date());
				session.update(tweet);
				session.getTransaction().commit();
				
			}else{
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		session.close();
		sessionFactory.close();
		
		return tweet;
	}
}
