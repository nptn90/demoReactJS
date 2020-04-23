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

@RestController
@RequestMapping(value = LoginController.PATH)
public class UserController {
	
	@Autowired
	PasswordUtils passwordGen;
	
	@PostMapping(value = "/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserPersist userPersist) {
		userPersist.setRoles(Arrays.asList(UserRole.ADMIN.toString()));
		String pasword = passwordGen.generatePassayPassword();
		String salt = passwordGen.getSalt();
		userPersist.setPassword(pasword);
		return null;
	}
}
