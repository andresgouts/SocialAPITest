package com.prueba.socialapitest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.socialapitest.domain.Photo;
import com.prueba.socialapitest.service.PhotoService;

@RestController
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/")
	public List<Photo> findAll(){
		return photoService.findAll();
	}
	
	@GetMapping("")
	public List<Photo> photosByUserId(@RequestParam long userId){
		return photoService.photosByUserId(userId);
	}
}
