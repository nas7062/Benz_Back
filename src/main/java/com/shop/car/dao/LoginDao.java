package com.shop.car.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.car.dto.Login;
import com.shop.car.dto.User;

@Mapper
public interface LoginDao {
	public void insertToken(Login login) throws Exception;
	public void deleteToken(String token) throws Exception;
	public User	 emailCheck(String email) throws Exception;
}
