package com.prueba.socialapitest.repository;

import java.util.List;

import com.prueba.socialapitest.domain.Photo;

public interface PhotoRepository {

	public List<Photo> findAll();
	
	public List<Photo> photosByAlbumId(long albumId);
}
