package com.example.demo.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.demo.security.user.UserAuthentication;
import com.example.demo.security.user.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	@Value(value = "${system.jwt.secret-key}")
	private String secretKey;

	@Value(value = "${system.jwt.expired-time}")
	private long expirationTime;
	
	@Autowired
	UserService userService;

	public String generateToken(UserAuthentication user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", user.getRoles());
		return doGenrateToken(claims, user.getName());
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	private String doGenrateToken(Map<String, Object> claims, String name) {
		long currentAtMillisecond = System.currentTimeMillis();
		return Jwts.builder().setClaims(claims).setSubject(name).setIssuedAt(new Date(currentAtMillisecond))
				.setExpiration(new Date(currentAtMillisecond + expirationTime * 60 * 1000))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}
	
	private boolean isTokenExpired(String token) {
		Date current = new Date();
		Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(current);
	}
	
	public boolean isTokenValid(String token, UserAuthentication user) {
		String userName = getUserNameFromToken(token);
		return (userName).equals(user.getName()) && !isTokenExpired(token);
	}

	public UserAuthentication parseUserFromToken(String token) {
		String userName = null;
		try {
			userName = getUserNameFromToken(token);
		} catch(ExpiredJwtException jwtEx) {
			userName = jwtEx.getClaims().getSubject();
		}

		if(!StringUtils.isEmpty(userName)) {
			return userService.loadUserByUserName(userName);
		}
		return null;
	}

}
