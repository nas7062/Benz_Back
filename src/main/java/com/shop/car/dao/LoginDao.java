package com.shop.car.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shop.car.dto.Login;
import com.shop.car.dto.User;

@Mapper
public interface LoginDao {
	public void insertToken(Login login) throws Exception;
	public void deleteToken(String token) throws Exception;
	public User	 emailCheck(String email) throws Exception;
	public Login checkToken(String authorization) throws Exception;
	public void updateLoginTime(@Param("user_id") int user_id, @Param("now") Date now) throws Exception;
}
