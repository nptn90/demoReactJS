package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.PasswordUtils;
import com.example.demo.entity.UserPersist;
import com.example.demo.security.user.Role.UserRole;
import com.example.demo.security.user.UserService;

@RestController
@RequestMapping(value = LoginController.PATH)
public class UserController {
	
	@Autowired
	PasswordUtils passwordGen;
	
	@Autowired 
	UserService userService;
	
	@PostMapping(value = "/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserPersist userPersist) {
		userPersist.setRoles(Arrays.asList(UserRole.USER.toString()));
		String password = passwordGen.generatePassayPassword();
		String encodedPassword = passwordGen.hashPassword(password);
		userPersist.setPassword(encodedPassword);
		userService.persistUser(userPersist);
		return ResponseEntity.ok().body(password);
	}
}
