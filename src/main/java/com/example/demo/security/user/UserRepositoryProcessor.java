package com.example.demo.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CRUDAbstract;
import com.example.demo.entity.UserPersist;

import java.util.List;

@Service
public class UserRepositoryProcessor extends CRUDAbstract<UserPersist, UserRepository, String> {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	public UserRepositoryProcessor(UserRepository  userRepo) {
		this.userRepo = userRepo;
	}
	
	public UserAuthentication loadUserByUserName(String name) {
		UserPersist user = userRepo.loadUserByUserName(name);
		return tranformToUserAuthentication(user);
	}
	
	public UserPersist loadByUserName(String name) {
		return userRepo.loadUserByUserName(name);
	}
	
	private UserAuthentication tranformToUserAuthentication(UserPersist userPersist) {
		UserAuthentication userAuth = null;
		if(userPersist != null) {
			userAuth = new UserAuthentication(userPersist.getName(), userPersist.getPassword(), userPersist.getRoles());
		}
		return userAuth;
	}

	public List<UserPersist> getAllUsers() {
		return userRepo.findAll();
	}

	public void removeUser(String userName) {
		UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		if(userAuthentication.getName().equals(userName)) {
			throw new RuntimeException("Cannot delete Admin roles");
		}

		UserPersist userPersist = userRepo.loadUserByUserName(userName);

		if(userPersist != null) {
			userRepo.delete(userPersist);
		} else {
			throw new RuntimeException("Not found user");
		}
	}
	
}
