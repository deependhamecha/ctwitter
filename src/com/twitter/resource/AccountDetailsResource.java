package com.twitter.resource;

import com.twitter.model.AccountDetails;
import com.twitter.databasecalls.DBConnection;

public class AccountDetailsResource {

	DBConnection dbConnection = null;
	
	AccountDetailsResource(){}
	
	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		dbConnection.setAccountDetails(accountDetails);
		return accountDetails;
	} 
}
