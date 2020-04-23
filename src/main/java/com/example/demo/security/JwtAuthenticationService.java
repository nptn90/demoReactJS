package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.example.demo.security.user.UserAuthentication;
import com.example.demo.security.user.UserService;

@Service
public class JwtAuthenticationService implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserAuthentication user = userService.loadUserByUserName(authentication.getName());
		if (user.getName().equals(authentication.getName())) {
            return user;
        }
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UserAuthentication.class);
	}
}
