package com.twitter.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="AccountDetails")
@XmlRootElement
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	
	private String name;
	private String emailAddress;
	private String profilePic;
	private String status;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	public AccountDetails(){
	}
	
	public AccountDetails(String name, String emailAddress, String profilePic,String status, String username, String password) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.profilePic = profilePic;
		this.status = status;
		this.username = username;
		this.password = password;
	}

	@OneToMany(mappedBy="username")
	private transient List<Tweet> tweet;
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Tweet> getTweet() {
		return tweet;
	}
	public void setTweet(List<Tweet> tweet) {
		this.tweet = tweet;
	}
	
	@Override
	public String toString() {
		return "AccountDetails [accountId=" + accountId + ", name=" + name
				+ ", emailAddress=" + emailAddress + ", profilePic="
				+ profilePic + ", status=" + status + ", username=" + username
				+ ", password=" + password + "]";
	}

	
	
	
}
