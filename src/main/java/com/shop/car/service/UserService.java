package com.shop.car.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.car.dao.LoginDao;
import com.shop.car.dao.UserDao;
import com.shop.car.dto.Login;
import com.shop.car.dto.User;
import com.shop.car.util.JwtTokenProvider;
import com.shop.car.util.OpenCrypt;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	LoginDao loginDao;

	public Login checkToken(String authorization) throws Exception {
		if (authorization != null && authorization.startsWith("Bearer")) {
			authorization = authorization.substring(7); // 'Bearer '를 제거하고 토큰만 남김
		}
		Login login = loginDao.checkToken(authorization);
		if (login == null) {
			return null;
		}
		long now = System.currentTimeMillis();
		long tokenTime = login.getLogin_time().getTime() + (30 * 60 * 1000);

		if (now > tokenTime) {
			loginDao.deleteToken(authorization);
			return null;
		}
		loginDao.updateLoginTime(login.getUser_id(), new Date(now)); // 로그인 시간 갱신
		return login;
	}

	@Transactional
	public void updateLoginTime(String token) throws Exception {
		// 1. 토큰을 사용해서 로그인한 유저 정보 가져오기
		Login login = loginDao.checkToken(token);
		if (login != null) {
			long now = System.currentTimeMillis();
			loginDao.updateLoginTime(login.getUser_id(), new Date(now)); // 2. user_id 기반으로 로그인 시간 갱신
		}
	}

	public Login tokenLogin(User user) throws Exception {

		user = userDao.login(user);
		System.out.println(user);
		if (user != null) {
			String email = user.getEmail();
			String username = user.getUsername();
			int id = user.getId();
			if (email != null && !email.trim().equals("")) {
				String jwtToken = JwtTokenProvider.createToken(email);
				Login loginInfo = new Login(id, jwtToken, new Timestamp(System.currentTimeMillis()), username);
				loginDao.insertToken(loginInfo);

				return loginInfo;
			}
		}

		return null;
	}

	public User login(User user) throws Exception {
		return userDao.login(user);
	}

	public void insertUser(User user) throws Exception {
		System.out.println(user);
		String email = user.getEmail();
		if (!isValidEmail(email)) {
			throw new Exception("유효하지 않은 이메일 형식입니다.");
		}
		// 패스워드 유효성 검사
		String password = user.getPassword();
		System.out.println(password);
		if (!isValidPassword(password)) {
			throw new Exception("패스워드는 8자리 이상이어야 하며 영어와 숫자를 포함해야 합니다.");
		}
		userDao.insertUser(user);
	}

	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	public void deleteUser(String email) throws Exception {
		userDao.deleteUser(email);
	}

	public void logout(String authorization) throws Exception {
		loginDao.deleteToken(authorization);

	}

	public boolean emailCheck(String email) throws Exception {
		return loginDao.emailCheck(email) != null;
	}

	private boolean isValidEmail(String email) {
		// 이메일 패턴
		String emailPattern = "^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\\.[A-Za-z]{2,3}$";
		return Pattern.matches(emailPattern, email);
	}

	// 패스워드 유효성 검사 메서드
	private boolean isValidPassword(String password) {
		// 패스워드 패턴: 8자리 이상, 숫자 및 영어포함.
		String passwordPattern = "^(?=.*[0-9]).{8,}$";
		return Pattern.matches(passwordPattern, password);
	}
	public boolean isLoginValid(String token) throws Exception {
	    Login loginInfo = checkToken(token); // 토큰 검증
	    if (loginInfo != null && loginInfo.getLogin_time() != null) {
	        long now = System.currentTimeMillis();
	        long lastTime = loginInfo.getLogin_time().getTime();
	        long interval = now - lastTime;
	        System.out.println("interval " + interval);
	        // 30분 이상 경과했으면 로그인 만료로 처리
	        if (interval > 60 * 30 * 1000) { // 30분
	        	loginDao.deleteToken(token);
	            return false;
	        } else {// 로그인 시간이 유효하면 갱신
	            updateLoginTime(token); // 로그인 시간 갱신
	            return true;
	        }
	    }
	    return false; // 로그인 정보가 없거나 로그인 시간이 null이면 false
	}
	
	

}
