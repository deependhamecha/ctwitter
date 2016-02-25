package com.twitter.businesslogic;

import com.twitter.DAO.AddDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;


/**
 * @author Deepen Dhamecha
 * This class adds AccountDetails and Tweets to Database.
 *
 */


public class AddDetails {

	AddDetailsDAO addDetailsDAO = new AddDetailsDAO();
	
	
	/** This method calls DAO Layer for database operation
	 * @param accountDetails Takes Account Details Object
	 * @return AccountDetails Returns AccountDetails Object after successful operation
	 * @throws no Exception
	 * @author Deepen Dhamecha
	 * @
	 */
	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		return addDetailsDAO.addAccountDetails(accountDetails);
	}
	
	
	/** This method calls DAO Layer for database operation
	 * @param tweet Takes Tweet Object
	 * @return Tweet Returns Tweet Object after successful operation 
	 */
	public Tweet addTweet(Tweet tweet){
		return addDetailsDAO.addTweet(tweet);
	}
}
