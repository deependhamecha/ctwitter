package com.twitter.businesslogic;

import com.twitter.DAO.UpdateDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/** This class Updates AccountDetails and Tweets by using methods for every operation individually.
 * @author Jax-L
 *
 */
public class UpdateDetails {
	
	UpdateDetailsDAO updateDetailsDAO = new UpdateDetailsDAO();
	
	/** Updates all AccountDetails by passing AccountDetails Object.
	 * @param AccountDetails AccountDetails object
	 * @return no Exception
	 */
	public AccountDetails updateAccountDetails(AccountDetails accountDetails){
		if(accountDetails.getName() != null){
			this.updateName(accountDetails.getAccountId(), accountDetails.getName());
		}
		
		if(accountDetails.getEmailAddress() != null){
			this.updateEmailAddress(accountDetails.getAccountId(), accountDetails.getEmailAddress());
		}
		
		if(accountDetails.getProfilePic() != null){
			this.updateProfilePic(accountDetails.getAccountId(), accountDetails.getProfilePic());
		}
		
		if(accountDetails.getStatus() != null){
			this.updateStatus(accountDetails.getAccountId(), accountDetails.getStatus());
		}
		
		if(accountDetails.getUsername() != null){
			this.updateUsername(accountDetails.getAccountId(), accountDetails.getUsername());
		}
		
		if(accountDetails.getPassword() != null){
			this.updatePassword(accountDetails.getAccountId(), accountDetails.getPassword());
		}
		
		return accountDetails;
	} 
	
	/** Updates name of AccountDetails by passing accountId and name.
	 * @param accountId AccountId of a User
	 * @param name Name of a User
	 * @return no Exception
	 */
	private boolean updateName(Integer accountId, String name){
		return  updateDetailsDAO.updateName(accountId, name);
	}
	
	/** Updates email address of AccountDetails by passing accountId and email address.
	 * @param accountId AccountId of a User
	 * @param emailAddress email address of a User
	 * @return no Exception
	 */
	private boolean updateEmailAddress(Integer accountId, String emailAddress){
		return updateDetailsDAO.updateEmailAddress(accountId, emailAddress);
	}
	
	/** Updates ProfilePic of AccountDetails by passing accountId and profilePicURL.
	 * @param accountId AccountId of a User
	 * @param profilePic Profile Pic URL of a User
	 * @return no Exception
	 */
	private boolean updateProfilePic(Integer accountId, String profilePic){
		return updateDetailsDAO.updateProfilePic(accountId, profilePic);
	}
	
	/** Updates Status of AccountDetails by passing accountId and status.
	 * @param accountId AccountId of a User
	 * @param status Status of a User
	 * @return no Exception
	 */
	private boolean updateStatus(Integer accountId, String status){
		return updateDetailsDAO.updateStatus(accountId, status);
	}
	
	/** Updates Username of AccountDetails by passing accountId and username.
	 * @param accountId AccountId of a User
	 * @param username Username of a User
	 * @return no Exception
	 */
	private boolean updateUsername(Integer accountId, String username){
		return updateDetailsDAO.updateUsername(accountId, username);
	}
	
	/** Updates Password of AccountDetails by passing accountId and password.
	 * @param accountId AccountId of a User
	 * @param password Password of a User
	 * @return no Exception
	 */
	private boolean updatePassword(Integer accountId, String password){
		return updateDetailsDAO.updatePassword(accountId, password);
	}
	
	/** Updates Tweet Message of AccountDetails by passing Tweet Object.
	 * @param Tweet Tweet Message of a User
	 * @return no Exception
	 */
	public Tweet updateTweetMessage(Tweet tweet){
		return updateDetailsDAO.updateTweetMessage(tweet);
	}
}
