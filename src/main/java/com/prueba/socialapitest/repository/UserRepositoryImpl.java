package com.prueba.socialapitest.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.prueba.socialapitest.domain.User;
import com.prueba.socialapitest.util.ConstantUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<User> findAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<User[]> response = template.getForEntity(
				ConstantUtil.TYPECODE_URL + ConstantUtil.USER_PATH, User[].class);
		return Arrays.asList(response.getBody());
		
	}

	@Override
	public User userById(long id) {
		RestTemplate template = new RestTemplate();
		String url = ConstantUtil.TYPECODE_URL + ConstantUtil.USER_PATH + 
		"/" + Long.toString(id);
		try {
			ResponseEntity<User> response = template.getForEntity(url, User.class);
			return response.getBody();
		} catch (Exception e) {
			return null;
		}
		
	}

}
