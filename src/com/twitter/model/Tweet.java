package com.twitter.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	/*@JoinColumn(name = "username")*/
	private String username;
	
	private String tweetMessage;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tweetDate;
	
	@ManyToOne(optional=true)
	@JoinColumn(referencedColumnName="username")
	private transient AccountDetails accountDetails;
	
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	public Tweet(){}
	
	public Tweet(String username, Date tweetDate, String tweetMessage) {
		super();
		this.username = username;
		this.tweetMessage = tweetMessage;
		this.tweetDate = tweetDate;
	}
	
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "Tweet [tweetId=" + tweetId + ", username=" + username
				+ ", tweet=" + tweetMessage + ", tweetDate=" + tweetDate + "]";
	}
	
	
}
