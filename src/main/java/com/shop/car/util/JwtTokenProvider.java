package com.shop.car.util;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtTokenProvider {
	private static String salt = Base64.getEncoder().encodeToString("솔트".getBytes());
	
	public static String createToken(String data) {
		Claims claims = Jwts.claims(); // 빈 claims 객체 생성
		claims.put("nickname", data); // nickname 필드에 data 저장

		Date now = new Date();
		System.out.println(now);

		return Jwts.builder().
				setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더 설정 (타입을 JWT로 설정)
				.setClaims(claims) // 데이터 설정
				.setIssuedAt(now) // 발급시간
				.setExpiration(new Date(now.getTime() + (1000L * 60 * 30))) // 만료시간 설정
				.signWith(SignatureAlgorithm.HS256, salt) // 서명
				.compact(); // 최종 JWT 문자열 생성
		
	}

	
	 
	public static boolean validateToken(String jwtToken) {
		return !getInformation(jwtToken).getExpiration().before(new Date()); //getInformation(jwtToken)토큰의 정보 가져옴
		// getExpiration().before(new Date())  시간과 비교하여 만료 여부 확인  만료시간이 지났으면 true임. 그러므로 !을 붙여야함
	}

	public static Claims getInformation(String jwtToken) {
		return Jwts.parser() 
				.setSigningKey(salt)  // salt를 사용하여 서명 검증
				.parseClaimsJws(jwtToken) // JWT 해석 및 서명 검증
				.getBody(); // payload (Claims) 반환
	}

}