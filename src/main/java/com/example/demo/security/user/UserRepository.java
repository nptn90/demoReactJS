package com.example.demo.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserPersist;

@Repository
public interface UserRepository extends JpaRepository<UserPersist, String> {
	
	@Query(value = "select u from userEntity u where u.name = ?1")
	UserPersist loadUserByUserName(String name);
}
