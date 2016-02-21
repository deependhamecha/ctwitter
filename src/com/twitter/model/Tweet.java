package com.twitter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Tweet")
@XmlRootElement
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tweetId;
	
	private Integer accountId;
	
	private String tweetMessage;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tweetDate;
	
	public Tweet(){}
	
	public Tweet(Integer accountId, Date tweetDate, String tweetMessage) {
		super();
		this.accountId = accountId;
		this.tweetMessage = tweetMessage;
		this.tweetDate = tweetDate;
	}
	
	public Integer getTweetId() {
		return tweetId;
	}
	private void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getTweetMessage() {
		return tweetMessage;
	}
	public void setTweetMessage(String tweetMessage) {
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
