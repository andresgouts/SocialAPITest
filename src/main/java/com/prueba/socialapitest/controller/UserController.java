package com.prueba.socialapitest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.socialapitest.domain.User;
import com.prueba.socialapitest.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> usuarios(){
		return userService.findAll();
	}
	
	@GetMapping("/authorizations")
	public List<User> authorizatedUsers(@RequestParam long albumId, @RequestParam char authorizationType){
		return userService.AuthorizatedUerd(albumId, authorizationType);
	}

}
