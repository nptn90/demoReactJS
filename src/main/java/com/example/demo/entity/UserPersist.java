package com.example.demo.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity(name = "userEntity")
@NoArgsConstructor
public class UserPersist {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "pass_word")
	private String password;
	
	@ElementCollection
	@CollectionTable(name = "roles")
	private List<String> roles;
	
	@Column(name = "email")
	private String email;
	
	@PersistenceConstructor
	public UserPersist(String name, String fullName, String password, List<String> roles, String email) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
		this.fullName = fullName;
		this.email = email;
	}
}
