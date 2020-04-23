package com.example.demo.security.user;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserPersist;

import lombok.Data;

@Service
public class UserService {

	@Autowired
	private UserRepositoryProcessor userRepo;

	@Autowired
	DefaultUser defaultUser;

	@PostConstruct
	void initMasterUser() {
		UserPersist userPersist = userRepo.loadByUserName(defaultUser.getUserName());
		if (userPersist == null) {
			userPersist = new UserPersist(defaultUser.getUserName(), defaultUser.getFullName(),
					defaultUser.getPassword(), defaultUser.getRoles(), defaultUser.getEmail());
			userRepo.save(userPersist);
		}
	}

	public UserAuthentication loadUserByRequest(String name, String passWord) {
		UserAuthentication userAuth = userRepo.loadUserByUserName(name);

		if (userAuth != null) {
			String cresdential = userAuth.getPassword();
			if (cresdential.equals(passWord)) {
				return userAuth;
			}
		}

		return null;
	}

	public UserAuthentication loadUserByUserName(String name) {
		return userRepo.loadUserByUserName(name);
	}

	@Configuration
	@ConfigurationProperties(prefix = "system.user")
	@Data
	static class DefaultUser {
		private String userName;
		private String fullName;
		private String password;
		private List<String> roles;
		private String email;
	}

}
