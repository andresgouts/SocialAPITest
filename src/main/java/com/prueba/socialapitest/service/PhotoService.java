package com.prueba.socialapitest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.socialapitest.domain.Photo;
import com.prueba.socialapitest.repository.AlbumRepository;
import com.prueba.socialapitest.repository.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public List<Photo> findAll(){
		return photoRepository.findAll();
	}
	
	public List<Photo> photosByUserId(long userId){
		List<Photo> userPhotos = new ArrayList<>();
		albumRepository.albumsByUser(userId).parallelStream().map(x -> photoRepository.photosByAlbumId(x.getId()))
		.forEach(x -> userPhotos.addAll(x));
		return userPhotos;
	}
	
}
