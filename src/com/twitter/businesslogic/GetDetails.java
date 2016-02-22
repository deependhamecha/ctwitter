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

public class GetDetails {

	public static final int maxNoOfTweets = 10;
	GetDetailsDAO getDetailsDAO = new GetDetailsDAO();
	
	public static void main(String ar[]){
		
		List<Tweet> tweetList = new GetDetailsDAO().getAllTweets();
		
		Iterator it = tweetList.iterator();
		
		while(it.hasNext()){
			System.out.println("Message : "+((Tweet)it.next()).getTweetMessage());
		}
	}
	
	public List<Tweet> getAllTweets(){	
		
		return getDetailsDAO.getAllTweets();
	}
	
	public List<Tweet> getUserTweets(Integer accountId){
		return getDetailsDAO.getUserTweets(accountId);
	}
	
	public Tweet getTweet(Integer tweetId){
		return getDetailsDAO.getTweet(tweetId);
	} 
	
	public AccountDetails getAccountDetails(Integer accountId){
		return getDetailsDAO.getAccountDetails(accountId);
	}
	
	/*public Integer getAccountIdOfTweetId(Integer tweetId){
		return getDetailsDAO.getAccountIdOfTweetId(tweetId);
	}*/
	
	public int getNoOfUserTweets(Integer accountId){
		return getDetailsDAO.getNoOfUserTweets(accountId);
	}
	
	public int getTotalNoOfTweets(){
		return getDetailsDAO.getTotalNoOfTweets();
	}
	
	public int getTotalNoOfAccountDetails(){
		return getDetailsDAO.getTotalNoOfAccountDetails();
	}
	
	public int getLastTweetId(){
		return getDetailsDAO.getLastTweetId();
	}
	
	public Integer checkCredentials(String username, String password){
		return getDetailsDAO.checkCredentials(username, password);
	}
}
