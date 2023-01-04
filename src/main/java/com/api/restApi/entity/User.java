package com.api.restApi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String user_email;
	private String userName;
	private String password;
	public User() {
	}

	public String getFirst_name() {
		return userName;
	}

	public void setFirst_name(String userName) {
		this.userName = userName;
	}

	

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
