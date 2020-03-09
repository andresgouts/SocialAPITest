package com.prueba.socialapitest.repository;

import java.util.List;

import com.prueba.socialapitest.domain.Album;

public interface AlbumRepository {
	
	public List<Album> findAll();
	
	public List<Album> albumsByUser(long userId);
	
	public Album albumById(long id);

}
