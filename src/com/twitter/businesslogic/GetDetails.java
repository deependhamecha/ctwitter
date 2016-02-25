package com.twitter.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.twitter.DAO.GetDetailsDAO;
import com.twitter.DAO.AddDetailsDAO;
import com.twitter.DAO.UpdateDetailsDAO;
import com.twitter.DAO.DeleteDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/** This class hits DAO layer class (GetDetails) and returns respective objects after successful operation. 
 * @author Deepen Dhamecha
 *
 */

public class GetDetails {

	public static final int maxNoOfTweets = 10;
	GetDetailsDAO getDetailsDAO = new GetDetailsDAO();
	
	
	/** Get all Tweets
	 * @return List<Tweet> Returns List of All Tweets
	 * @throws no Exception 
	 */
	public List<Tweet> getAllTweets(){	
		return getDetailsDAO.getAllTweets();
	}
	
	/** Get all tweets of a user
	 * @return List<Tweet> Returns List of All particular User Tweets
	 * @param tweetId Unique TweetId for All Tweets
	 * @throws no Exception 
	 */
	public List<Tweet> getUserTweets(Integer accountId){
		return getDetailsDAO.getUserTweets(accountId);
	}
	
	/** Get a particular tweet using accountId
	 * @return Tweet Returns a particular Tweet by passing TweetId
	 * @param tweetId Unique TweetId for All Tweets
	 * @throws no Exception 
	 */
	public Tweet getTweet(Integer tweetId){
		return getDetailsDAO.getTweet(tweetId);
	} 
	
	/** Get AccountDetails of a particular user using accountId
	 * @return AccountDetails Returns a particular AccountDetails by passing accountId
	 * @param accountId Unique accountId for all AccountDetails
	 * @throws no Exception 
	 */
	public AccountDetails getAccountDetails(Integer accountId){
		return getDetailsDAO.getAccountDetails(accountId);
	}
	
	/** Get AccountDetails of a particular user using Username
	 * @return AccountDetails Returns a particular AccountDetails by passing username
	 * @param username Unique username for all AccountDetails
	 * @throws no Exception 
	 */
	public AccountDetails getAccountDetails(String username){
		return getDetailsDAO.getAccountDetails(username);
	}
	
	/**
	 * @return int Returns number of a particular User Tweets referred by accountId
	 * @param accountId Unique accountId for all AccountDetails
	 * @throws no Exception 
	 */
	public int getNoOfUserTweets(Integer accountId){
		return getDetailsDAO.getNoOfUserTweets(accountId);
	}
	
	/**
	 * @return int Returns total number of Tweets
	 * @throws no Exception 
	 */
	public int getTotalNoOfTweets(){
		return getDetailsDAO.getTotalNoOfTweets();
	}
	
	/**
	 * @return int Returns total number of AccountDetails
	 * @throws no Exception 
	 */
	public int getTotalNoOfAccountDetails(){
		return getDetailsDAO.getTotalNoOfAccountDetails();
	}
	
	/**
	 * @return int Return Last TweetId
	 * @throws no Exception 
	 */
	public int getLastTweetId(){
		return getDetailsDAO.getLastTweetId();
	}
	
	/**
	 * @return Integer Returns total number of Tweets
	 * @throws no Exception 
	 */
	public Integer checkCredentials(String username, String password){
		return getDetailsDAO.checkCredentials(username, password);
	}
}
