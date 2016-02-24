package com.twitter.businesslogic;

import com.twitter.DAO.DeleteDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class DeleteDetails {

	DeleteDetailsDAO deleteDetailsDAO = new DeleteDetailsDAO();
	
	public boolean deleteAccountDetails(AccountDetails accountDetails) {
		return deleteDetailsDAO.deleteAccountDetails(accountDetails);
	}

	
	public boolean deleteAllTweets(Integer accountId) {
		return deleteDetailsDAO.deleteAllTweets(accountId);
	}

	
	public boolean deleteTweet(Tweet tweet) {
		return deleteDetailsDAO.deleteTweet(tweet);
	}
	
	
}
