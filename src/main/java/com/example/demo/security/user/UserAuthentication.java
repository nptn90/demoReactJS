package com.example.demo.security.user;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = 1L;
	String name;
	String password;
	List<String> roles;
	private final static String ROLE_PREFIX = "ROLE_";
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return map2Roles();
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
	
	private List<Role> map2Roles() {
		return roles.stream().map(item -> {
			return new Role(ROLE_PREFIX + item);
		}).collect(Collectors.toList());
	}

}
