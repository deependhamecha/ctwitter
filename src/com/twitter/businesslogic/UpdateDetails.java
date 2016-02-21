package com.twitter.businesslogic;

import com.twitter.DAO.UpdateDetailsDAO;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

public class UpdateDetails {
	
	UpdateDetailsDAO updateDetailsDAO = new UpdateDetailsDAO();
	
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
	
	private boolean updateName(Integer accountId, String name){
		return  updateDetailsDAO.updateName(accountId, name);
	}
	
	private boolean updateEmailAddress(Integer accountId, String emailAddress){
		return updateDetailsDAO.updateEmailAddress(accountId, emailAddress);
	}
	
	private boolean updateProfilePic(Integer accountId, String profilePic){
		return updateDetailsDAO.updateProfilePic(accountId, profilePic);
	}
	
	private boolean updateStatus(Integer accountId, String status){
		return updateDetailsDAO.updateStatus(accountId, status);
	}
	
	private boolean updateUsername(Integer accountId, String username){
		return updateDetailsDAO.updateUsername(accountId, username);
	}
	
	private boolean updatePassword(Integer accountId, String password){
		return updateDetailsDAO.updatePassword(accountId, password);
	}
	
	public Tweet updateTweetMessage(Tweet tweet){
		return updateDetailsDAO.updateTweetMessage(tweet);
	}
}
