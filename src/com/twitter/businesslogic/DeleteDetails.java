package com.twitter.businesslogic;

import com.twitter.DAO.DeleteDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/** This class hits DAO layer class (DeleteDetails) and returns respective objects after successful operation.
 * @author Deepen Dhamecha
 * 
 */
public class DeleteDetails {

	DeleteDetailsDAO deleteDetailsDAO = new DeleteDetailsDAO();

	/** Deletes AccountDetails of a User
	 * @param accountDetails AccountDetails Object of a User
	 * @return boolean Returns true if successful deletion and false if not. 
	 * @throws no Exception
	 */
	public boolean deleteAccountDetails(AccountDetails accountDetails) {
		return deleteDetailsDAO.deleteAccountDetails(accountDetails);
	}

	/** Deletes All Tweets of a particular user using accountId
	 * @param accountId Unique accountId of a particular User AccountDetails
	 * @return boolean Returns true if successful deletion and false if not. 
	 * @throws no Exception
	 */
	public boolean deleteAllTweets(Integer accountId) {
		return deleteDetailsDAO.deleteAllTweets(accountId);
	}

	/** Deletes a particular Tweet using tweetId
	 * @param accountDetails AccountDetails of a User
	 * @return boolean Returns true if successful deletion and false if not. 
	 * @throws no Exception
	 */
	public boolean deleteTweet(Tweet tweet) {
		return deleteDetailsDAO.deleteTweet(tweet);
	}
	
	
}
