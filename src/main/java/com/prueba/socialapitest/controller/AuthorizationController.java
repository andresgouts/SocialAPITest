package com.prueba.socialapitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prueba.socialapitest.Exception.BadRequestException;
import com.prueba.socialapitest.Exception.NotFoundException;
import com.prueba.socialapitest.domain.Authorization;
import com.prueba.socialapitest.service.AuthorizationService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@PostMapping("")
	public Authorization createAuthorization(@RequestBody Authorization autorization) {
		try {
			return authorizationService.createAuthorization(autorization);
		} catch (BadRequestException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		} catch (NotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PutMapping("")
	public Authorization updateAuthorization(@RequestBody Authorization authorization) {
		try {
			return authorizationService.updateAuthorization(authorization);
		} catch (NotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
}
