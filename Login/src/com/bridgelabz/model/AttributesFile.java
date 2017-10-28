package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class AttributesFile {
	
	private String userName;
	
	private String password;
	
	private long mobileNumber;
	
	private String emailId;
	
	public AttributesFile() {
		userName=null;
		password=null;
		mobileNumber=0;
		emailId=null;
	}
	
	@Id
	@Column(name="Email_Id")
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	
	@Column(name="User_Name")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	@Column(name="Password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	@Column(name="Mobile_Number")
	public long getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
}
