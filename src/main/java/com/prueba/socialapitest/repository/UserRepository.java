package com.prueba.socialapitest.repository;

import java.util.List;

import com.prueba.socialapitest.domain.User;

public interface UserRepository {
	
	List<User> findAll();
	
	User userById(long id);

}
