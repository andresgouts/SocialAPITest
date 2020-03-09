package com.prueba.socialapitest.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.prueba.socialapitest.domain.Album;
import com.prueba.socialapitest.util.ConstantUtil;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

	@Override
	public List<Album> findAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Album[]> response = template.getForEntity(
				ConstantUtil.TYPECODE_URL + ConstantUtil.ALBUMS_PATH, Album[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<Album> albumsByUser(long userId) {
		RestTemplate template = new RestTemplate();
		String url = ConstantUtil.TYPECODE_URL + ConstantUtil.ALBUMS_PATH + 
		"?userId=" + Long.toString(userId);
		ResponseEntity<Album[]> response = template.getForEntity(url, Album[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public Album albumById(long id) {
		RestTemplate template = new RestTemplate();
		String url = ConstantUtil.TYPECODE_URL + ConstantUtil.ALBUMS_PATH + 
		"/" + Long.toString(id);
		try {
			ResponseEntity<Album> response = template.getForEntity(url, Album.class);
			return response.getBody();
		} catch (Exception e) {
			return null;
		}
		
	}

}
