package com.twitter.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.twitter.businesslogic.AddDetails;
import com.twitter.businesslogic.DeleteDetails;
import com.twitter.businesslogic.GetDetails;
import com.twitter.businesslogic.UpdateDetails;
import com.twitter.model.AccountDetails;
import com.twitter.model.Tweet;

/** This class is Web Service for AccountDetails class and does operation based on URI and HTTP Method
 * Note : It only consumes JSON format and returns JSON format
 * @author Deepen Dhamecha
 *
 */
@Path("/accountdetails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountDetailsService {

	AddDetails addDetails = new AddDetails();
	GetDetails getDetails = new GetDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	
	
	/** This method gets a particular AccountDetails by username
	 * @param username
	 * @return AccountDetails Returns JSON format of AccountDetails if successful 
	 */
	@GET
	@Path("/getaccountdetails/{username}")
	public AccountDetails getAccountDetails(@PathParam("username") String username){
		AccountDetails ad = getDetails.getAccountDetails(username);
		return ad;
	}
	
	/** This method creates AccountDetails based on JSON data consumed and returns JSON data if successful
	 * @return accountDetails Returns JSON format of AccountDetails if successful 
	 */
	@POST
	@Path("/create")
	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		accountDetails = addDetails.addAccountDetails(accountDetails);
		return accountDetails;
	}
	
	/** This method updates a particular AccountDetails by accountId
	 * @param accountId
	 * @return accountDetails Returns JSON format of AccountDetails if successful 
	 */
	@PUT
	@Path("/update/{accountId}")
	public AccountDetails updateAccountDetails(@PathParam("accountId") Integer accountId, AccountDetails accountDetails){
		accountDetails.setAccountId(accountId);
		return updateDetails.updateAccountDetails(accountDetails);
	}
	
	/** This method deletes a particular AccountDetails by accountId
	 * @param accountId
	 * @return accountDetails Returns JSON format of AccountDetails if successful 
	 */
	@DELETE
	@Path("/delete/{accountId}")
	public AccountDetails deleteAccountDetails(@PathParam("accountId") Integer accountId, AccountDetails accountDetails){
		accountDetails.setAccountId(accountId);
		if(deleteDetails.deleteAccountDetails(accountDetails)){
			return accountDetails;
		}else{
			return null;
		}
	}
		
}
