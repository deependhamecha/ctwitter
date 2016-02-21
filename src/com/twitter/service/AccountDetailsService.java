package com.twitter.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.twitter.businesslogic.AddDetails;
import com.twitter.businesslogic.DeleteDetails;
import com.twitter.businesslogic.GetDetails;
import com.twitter.businesslogic.UpdateDetails;
import com.twitter.model.AccountDetails;

@Path("/accountdetails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountDetailsService {
	
	AddDetails addDetails = new AddDetails();
	GetDetails getDetails = new GetDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	
	@GET
	@Path("/getaccountdetails/{accountId}")
	public AccountDetails getAccountDetails(@PathParam("accountId") Integer accountId){
		return getDetails.getAccountDetails(accountId);
	}
	
	@POST
	@Path("/create")
	public AccountDetails addAccountDetails(AccountDetails accountDetails){
		return addDetails.addAccountDetails(accountDetails);
	}
}
