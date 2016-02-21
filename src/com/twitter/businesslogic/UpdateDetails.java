package com.twitter.businesslogic;

import com.twitter.DAO.UpdateDetailsDAO;

public class UpdateDetails {
	
	UpdateDetailsDAO updateDetailsDAO = new UpdateDetailsDAO();
	
	public boolean updateName(Integer accountId, String name){
		return  updateDetailsDAO.updateName(accountId, name);
	}
	
	public boolean updateEmailAddress(Integer accountId, String emailAddress){
		return updateDetailsDAO.updateEmailAddress(accountId, emailAddress);
	}
	
	public boolean updateProfilePic(Integer accountId, String profilePic){
		return updateDetailsDAO.updateProfilePic(accountId, profilePic);
	}
	
	public boolean updateStatus(Integer accountId, String status){
		return updateDetailsDAO.updateStatus(accountId, status);
	}
	
	public boolean updateUsername(Integer accountId, String username){
		return updateDetailsDAO.updateUsername(accountId, username);
	}
	
	public boolean updatePassword(Integer accountId, String password){
		return updateDetailsDAO.updatePassword(accountId, password);
	}
	
	public boolean updateTweetMessage(Integer tweetId, String tweetMessage){
		return updateDetailsDAO.updateTweetMessage(tweetId, tweetMessage);
	}
}
