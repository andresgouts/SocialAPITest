package com.prueba.socialapitest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.socialapitest.domain.Album;
import com.prueba.socialapitest.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public List<Album> findAll(){
		return albumRepository.findAll();
	}
	
	public List<Album> albumsByUser(long userId){
		return albumRepository.albumsByUser(userId);
	}
}
