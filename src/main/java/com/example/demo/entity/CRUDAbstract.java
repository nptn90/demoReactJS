package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class  CRUDAbstract<E, R extends CrudRepository<E, I>, I>  {
	
	@Autowired
	R repo;
	public E save(E entity) {
		return repo.save(entity);
	}
}
