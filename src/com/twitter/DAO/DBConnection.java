package com.twitter.DAO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;



import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class DBConnection {

	public static void main(String arg[]){		

		//AccountDetails accountDetails = new AccountDetails("Dilisha", "deepen@gmail.com", "myphoto", "Nothing is true", "deepen91", "xyz");
		//Tweet tweet = new Tweet(5, "OhkyXyz", new Timestamp(new Date().getTime()));
		
		/*#############################################
		### Adding AccountDetails & Tweet Testing ###
		#############################################*/
		  
	/*	AddDetailsDAO add = new AddDetailsDAO();*/
		/*AccountDetails ad = add.addAccountDetails(accountDetails);*/
		
	/*	System.out.println(" : "+accountDetails.getAccountId());
		System.out.println(" : "+accountDetails.getName());
		System.out.println(" : "+accountDetails.getEmailAddress());
		System.out.println(" : "+accountDetails.getProfilePic());
		System.out.println(" : "+accountDetails.getStatus());
		System.out.println(" : "+accountDetails.getUsername());
		System.out.println(" : "+accountDetails.getPassword()); */

		/*Tweet t = add.addTweet(tweet,5);
		
		System.out.println(" : "+t.getTweetId());
		System.out.println(" : "+t.getAccountId());
		System.out.println(" : "+t.getTweetMessage());
		System.out.println(" : "+t.getTweetDate());*/
		
		// ----------------------------------------------------------------------------------------------------------
		
		/*
		#############################################
		### Getting AccountDetails & Tweet Testing ###
		#############################################
		*/
		
		/*GetDetailsDAO get = new GetDetailsDAO();*/
	/*	System.out.println(get.getNoOfUserTweets(4));
		System.out.println(get.getTotalNoOfAccountDetails());
		System.out.println(get.getTotalNoOfTweets());

		System.out.println("AccountDetails : "+get.getAccountDetails(4)); */
		/*System.out.println("Tweet : "+get.getTweet(1));*/
		
		
		/*UpdateDetailsDAO updateDetailsDao = new UpdateDetailsDAO();*/
		
		/* System.out.println(updateDetailsDao.updateName(1, "Dilisha"));
		System.out.println(updateDetailsDao.updateEmailAddress(1,"dilishadhamecha@gmail.com"));
		System.out.println(updateDetailsDao.updateProfilePic(1, "Abc"));
		System.out.println(updateDetailsDao.updateStatus(1, "Inci Vinci Spider"));
		System.out.println(updateDetailsDao.updateUsername(1,"dlishad"));
		System.out.println(updateDetailsDao.updatePassword(1, "password"));*/
		/*System.out.println(updateDetailsDao.updateTweetMessage(1, "Lollipop Man!"));*/
		
		/*DeleteDetailsDAO deleteDaoDetailsDAO = new DeleteDetailsDAO();*/
		/*System.out.println(deleteDaoDetailsDAO.deleteTweet(1, 1));*/ 
		/*System.out.println(deleteDaoDetailsDAO.deleteAllTweets(1));*/
		/*System.out.println(deleteDaoDetailsDAO.deleteAccountDetails(1));*/
		
		/*System.out.println(get.checkCredentials("naresh", "abc"));*/
	}	
}
