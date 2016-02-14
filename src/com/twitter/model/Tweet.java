package com.twitter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Tweet")
public class Tweet {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tweetId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	
	private String tweetMessage;
	
	@Temporal(TemporalType.DATE)
	private Date tweetDate;
	
	public Integer getTweetId() {
		return tweetId;
	}
	private void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	private void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getTweetMessage() {
		return tweetMessage;
	}
	public void setTweet(String tweetMessage) {
		this.tweetMessage = tweetMessage;
	}
	public Date getTweetDate() {
		return tweetDate;
	}
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", accountId=" + accountId
				+ ", tweet=" + tweetMessage + ", tweetDate=" + tweetDate + "]";
	}
	
	
}
