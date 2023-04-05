package com.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This class become model class and it will create table with class Name ,i.e.
		// Users
@Table(name = "tbl_users") // This is optional and it will create a table with tbl_user name
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long userId;

	private String userName;
	private String userMail;
	private String userPhoneNo;

	public Users(String userName, String userMail, String userPhoneNo) {
		super();
		this.userName = userName;
		this.userMail = userMail;
		this.userPhoneNo = userPhoneNo;
	}

	public Users() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

}
