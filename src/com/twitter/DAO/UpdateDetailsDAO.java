package com.twitter.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class UpdateDetailsDAO {

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
	
	public boolean updateTweetMessage(Integer tweetId, String tweetMessage){
		
		boolean flag = true;
		
		SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Tweet tweet = null;
		
		try{
			if(tweetMessage != null && tweetId != null){
				tweet = (Tweet) session.get(Tweet.class, tweetId);
				tweet.setTweetMessage(tweetMessage);
				tweet.setTweetDate(new Date());
				session.update(tweet);
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
	
	
}
