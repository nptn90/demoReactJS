package com.example.demo.security.user;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.common.PasswordUtils;
import com.example.demo.entity.UserPersist;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepositoryProcessor userRepo;
	
	@Autowired
	private PasswordUtils passwordUtils;

	@Autowired
	DefaultUser defaultUser;

	@PostConstruct
	void initMasterUser() {
		try {
			UserPersist userPersist = userRepo.loadByUserName(defaultUser.getUserName());
			if (userPersist == null) {
				String password = passwordUtils.hashPassword(defaultUser.getPassword());
				userPersist = new UserPersist(defaultUser.getUserName(), defaultUser.getFullName(),
						password, defaultUser.getRoles(), defaultUser.getEmail());
				userRepo.save(userPersist);
			}
		} catch(Exception ex) {
			log.warn("Cannot init user on this node");
		}
	}

	public UserAuthentication loadUserByRequest(String name, String passWord) {
		UserAuthentication userAuth = userRepo.loadUserByUserName(name);

		if (userAuth != null) {
			String cresdential = userAuth.getPassword();
			if (passwordUtils.isPasswordMatch(passWord, cresdential)) {
				return userAuth;
			}
		}

		return null;
	}
	
	public UserPersist persistUser(UserPersist u) {
		return userRepo.save(u);
	}

	public UserAuthentication loadUserByUserName(String name) {
		return userRepo.loadUserByUserName(name);
	}

	public List<UserPersist> getAllUsers() {
		return userRepo.getAllUsers();
	}

	public void removeUser(String userName) {
		userRepo.removeUser(userName);
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
