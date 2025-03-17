package com.shop.car.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.car.dto.User;


@Mapper
public interface UserDao {
	public User login(User user) throws Exception;
	public void insertUser(User m) throws Exception;
	public void updateUser(User m) throws Exception;
	public void deleteUser(String email) throws Exception;
}
