package com.shop.car.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.car.dao.LoginDao;
import com.shop.car.dao.UserDao;
import com.shop.car.dto.Login;
import com.shop.car.dto.User;
import com.shop.car.util.OpenCrypt;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	LoginDao loginDao;

	public Login tokenLogin(User user) throws Exception {
		System.out.println(user);
		user=userDao.login(user);
		
		if(user!=null) {
			String username=user.getUsername();
			if(username!=null && !username.trim().equals("")) {
				//member table에서 email과 pwd가 확인된 상황 즉 login ok
				
				String password=user.getPassword();
				int id = user.getId();
				//1. salt를 생성한다
				String salt=UUID.randomUUID().toString();
				System.out.println("salt:"+salt);
				//2. email을 hashing 한다
				byte[] originalHash=OpenCrypt.getSHA256(password, salt);
				//3. db에 저장하기 좋은 포맷으로 인코딩한다
				String myToken=OpenCrypt.byteArrayToHex(originalHash);
				System.out.println("myToken : "+myToken);
				//4. login table에 token 저장
				Login loginInfo=new Login(id, myToken,new Timestamp(System.currentTimeMillis()),username);
				loginDao.insertToken(loginInfo);
				return loginInfo;
			}
		}
		
		return null;		 
	}
	
	public User login(User user) throws Exception {
		return userDao.login(user);
	}
	
	public void insertUser(User user) throws Exception{
		userDao.insertUser(user);
	}
	
	public void updateUser(User user) throws Exception{
		userDao.updateUser(user);
	}
	
	public void deleteUser(String email) throws Exception{
		userDao.deleteUser(email);
	}

	public void logout(String authorization) throws Exception {
		loginDao.deleteToken(authorization);
		
	}
	public boolean emailCheck(String email) throws Exception {
		  return loginDao.emailCheck(email) != null;
	}

}
