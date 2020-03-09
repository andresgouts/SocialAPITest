package com.prueba.socialapitest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.socialapitest.domain.Authorization;
import com.prueba.socialapitest.domain.User;
import com.prueba.socialapitest.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public List<User> AuthorizatedUerd(long albumId, char authorizationType){
		List<Authorization> authorizations = authorizationService.findByAlbumId(albumId);
		return authorizations.stream().filter(x -> x.getAuthorizationType() == authorizationType).
				map(x -> userRepository.userById(x.getUserId())).collect(Collectors.toList());
	}
	
}
