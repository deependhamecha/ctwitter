package com.twitter.service;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.twitter.businesslogic.AddDetails;
import com.twitter.businesslogic.DeleteDetails;
import com.twitter.businesslogic.GetDetails;
import com.twitter.businesslogic.UpdateDetails;
import com.twitter.model.Tweet;

@Path("/tweet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TweetService{

	AddDetails addDetails = new AddDetails();
	GetDetails getDetails = new GetDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	

	@GET
	@Path("/gettweets")
	public List<Tweet> getAllTweets(){
		return getDetails.getAllTweets();
	}
	
	@GET
	@Path("/gettweets/{accountId}")
	public List<Tweet> getAllTweets(@PathParam("accountId") Integer accountId){
		return getDetails.getUserTweets(accountId);
	}
	
	@POST
	@Path("/create")
	public Tweet addTweet(Tweet tweet){
		return addDetails.addTweet(tweet);
	}
	
		
}
