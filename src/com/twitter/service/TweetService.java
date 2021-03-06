package com.twitter.service;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

/** This class is Web Service for Tweet class and does operation based on URI and HTTP Method
 * Note : It only consumes JSON format and returns JSON format
 * @author Jax-L
 *
 */
@Path("/tweet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TweetService{

	AddDetails addDetails = new AddDetails();
	GetDetails getDetails = new GetDetails();
	UpdateDetails updateDetails = new UpdateDetails();
	DeleteDetails deleteDetails = new DeleteDetails();
	
	
	/** This method gets all Tweets
	 * @return List<Tweet> Returns JSON format of List<Tweet> if successful 
	 */
	@GET
	@Path("/gettweets")
	public List<Tweet> getAllTweets(){
		return getDetails.getAllTweets();
	}
	
	/** This method gets all Tweets of a user
	 * @param accountId Takes accountId to identify a user's AccountDetails
	 * @return List<Tweet> Returns JSON format of List<Tweet> if successful 
	 */
	@GET
	@Path("/gettweets/{accountId}")
	public List<Tweet> getAllTweets(@PathParam("accountId") Integer accountId){
		return getDetails.getUserTweets(accountId);
	}
	
	/** This method creates a tweet
	 * @return Tweet Returns JSON format of Tweet if successful 
	 */
	@POST
	@Path("/create")
	public Tweet addTweet(Tweet tweet){
		System.out.println(tweet.getTweetMessage());
		System.out.println(tweet.getUsername());
		tweet = addDetails.addTweet(tweet);
		return tweet;
	}
	
	/** This method updates a Tweet
	 * @return List<Tweet> Returns JSON format of Tweet if successful 
	 */
	@PUT
	@Path("/update/{tweetId}")
	public Tweet updateTweetMessage(@PathParam("tweetId") Integer tweetId, Tweet tweet){
		tweet.setTweetId(tweetId);
		return updateDetails.updateTweetMessage(tweet);
	}
	
	/** This method deletes a Tweet by tweetId
	 * @param tweetId Takes tweetId
	 * @return Tweet Returns JSON format of Tweet if successful 
	 */
	@DELETE
	@Path("/delete/{tweetId}")
	public Tweet deleteTweet(@PathParam("tweetId") Integer tweetId, Tweet tweet){
		tweet = new Tweet();
		tweet.setTweetId(tweetId);
		if(deleteDetails.deleteTweet(tweet)){
			return tweet;
		}else{
			return null;
		}
	}
}
