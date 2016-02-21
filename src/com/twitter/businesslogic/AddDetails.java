package com.twitter.businesslogic;

import com.twitter.DAO.AddDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class AddDetails {

	AddDetailsDAO addDetailsDAO = new AddDetailsDAO();
	
	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		return addDetailsDAO.addAccountDetails(accountDetails);
	}
	
	public Tweet addTweet(Tweet tweet){
		return addDetailsDAO.addTweet(tweet);
	}
}
