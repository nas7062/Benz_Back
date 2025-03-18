package com.shop.car.dto;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	
	private int id;
	private String email,password,username;
	private Date regist_date;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String email, String password, String username, Date regist_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.regist_date = regist_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", regist_date=" + regist_date + "]";
	}
	
	
}
