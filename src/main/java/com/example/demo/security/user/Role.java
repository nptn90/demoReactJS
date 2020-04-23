package com.example.demo.security.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

	public static enum UserRole {
		ADMIN, USER
	}
	
	private static final long serialVersionUID = 1L;
	private String role;
	
	@Override
	public String getAuthority() {
		return role;
	}
}
