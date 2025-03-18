package com.shop.car.dto;

import java.sql.Timestamp;
import java.util.Date;


public class Login {
	
	private String  token,username;
	private int user_id;
	private Date login_time;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int user_id, String token, Date login_time,String username) {
		super();
		this.user_id = user_id;
		this.token = token;
		this.login_time = login_time;
		this.username = username;
	}

	
}
	


