package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtAuthenticationService;
import com.example.demo.security.JwtTokenUtils;
import com.example.demo.security.user.UserAuthentication;
import com.example.demo.security.user.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value = LoginController.PATH)
public class LoginController {
	final static String PATH = "/api/public";

	@Autowired
	UserService userService;
	
	@Autowired
	JwtAuthenticationService authenticationManager;
	
	@Autowired
	JwtTokenUtils tokenUtils;

	@PostMapping(value = "/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws Exception {
		UserAuthentication user = userService.loadUserByRequest(request.getUserName(), StringUtils.trimAllWhitespace(request.getPassWord()));
		if (user != null) {
			String token = tokenUtils.generateToken(user);
			long expirationDate = tokenUtils.getExpirationDateFromToken(token).getTime();
			return new ResponseEntity<JwtResponse>(new JwtResponse(token, expirationDate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/refresh")
	public ResponseEntity<JwtResponse> refreshToken(@RequestBody String token) throws Exception {
		UserAuthentication user = tokenUtils.parseUserFromToken(token);
		if (user != null) {
			String newToken = tokenUtils.generateToken(user);
			long expirationDate = tokenUtils.getExpirationDateFromToken(token).getTime();
			return new ResponseEntity<JwtResponse>(new JwtResponse(newToken, expirationDate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
final class JwtRequest {
	private String userName;
	private String passWord;
}

@AllArgsConstructor
@Data
final class JwtResponse {
	String token;
	long expirationDate;
}
