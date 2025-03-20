package com.shop.car.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shop.car.dto.Login;
import com.shop.car.dto.User;
import com.shop.car.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("logout")
	public ResponseEntity<?> logout(@RequestHeader String authorization) {
	    System.out.println(authorization);
	    try {
	        // 토큰 유효성 검사
	        if (!userService.isLoginValid(authorization)) {
	        	System.out.println("토큰만료");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰이 만료되었습니다.");
	        }

	        userService.logout(authorization); // 로그아웃 처리
	        return ResponseEntity.ok("로그아웃 성공");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류 발생");
	    }
	}
	
	@GetMapping("check-session")
	public ResponseEntity<?> checkSession(@RequestHeader String authorization) {
	    try {
			if (!userService.isLoginValid(authorization)) {
				System.out.println("토큰만료");
			    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰이 만료되었습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return ResponseEntity.ok().body("세션 유지 중");
	}
	@PostMapping("tokenLogin")
	public Map<String,String> tokenLogin(@RequestBody User user) {
		System.out.println(user);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try {
			Login loginInfo=userService.tokenLogin(user);
			
			if(loginInfo!=null && loginInfo.getUsername()!= null && loginInfo.getToken()!=null) {
				responseMap.put("username",loginInfo.getUsername());
				responseMap.put("Authorization", loginInfo.getToken());
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	
	@PostMapping("login")
	public Map<String,String> login(@RequestBody User user) {
		System.out.println(user);
		
		Map<String,String> responseMap=new HashMap<>();
		
		try {
			user=userService.login(user);
			String username=user.getUsername();
			if(user!=null && username!=null && !username.trim().equals("")) {
				responseMap.put("username", username);
			}else {
				responseMap.put("msg", "다시 로그인 해주세요");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseMap.put("msg", "다시 로그인 해주세요");
		}
		return responseMap;
	}
	
	@PostMapping("insertUser")
	public String insertUser(@RequestBody User user) {
		System.out.println(user);
		try {
			userService.insertUser(user);
			return user.getUsername()+"님 가입을 환영합니다";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "회원 가입 실패";
		}
	}
	
	@PostMapping("updateUser")
	public String updateUser(@RequestBody User user) {
		System.out.println(user);	
		try {
			userService.updateUser(user);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
	
	@PostMapping("deleteUser")
	public String deleteUser(@RequestBody String email) {
		System.out.println(email);
		try {
			userService.deleteUser(email);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "email과 pwd 확인해 주세요";
		}
	}
	
	@PostMapping("emailCheck")
	public boolean emailCheck( @RequestParam String email) {
		 boolean exists = false;
		try {
			exists = userService.emailCheck(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exists;
		
	}

}

