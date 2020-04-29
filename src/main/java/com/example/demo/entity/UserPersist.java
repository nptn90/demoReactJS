package com.example.demo.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity(name = "userEntity")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPersist extends BaseEntity {

	@Column(name = "name", unique = true)
	@NonNull
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
}
