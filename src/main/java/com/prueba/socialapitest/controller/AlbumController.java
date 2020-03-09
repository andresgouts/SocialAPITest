package com.prueba.socialapitest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.socialapitest.domain.Album;
import com.prueba.socialapitest.service.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("/")
	public List<Album> findAll(){
		return albumService.findAll();
	}
	
	@GetMapping("")
	public List<Album> albumsByUserId(@RequestParam long userId){
		return albumService.albumsByUser(userId);
	}
}
