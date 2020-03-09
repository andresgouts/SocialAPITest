package com.prueba.socialapitest.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.prueba.socialapitest.domain.Photo;
import com.prueba.socialapitest.util.ConstantUtil;

@Repository
public class PhotoRepositoryImpl implements PhotoRepository {

	@Override
	public List<Photo> findAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Photo[]> response = template.getForEntity(
				ConstantUtil.TYPECODE_URL + ConstantUtil.PHOTOS_PATH, Photo[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<Photo> photosByAlbumId(long albumId) {
		RestTemplate template = new RestTemplate();
		String url = ConstantUtil.TYPECODE_URL + ConstantUtil.PHOTOS_PATH + 
		"?albumId=" + Long.toString(albumId);
		ResponseEntity<Photo[]> response = template.getForEntity(url, Photo[].class);
		return Arrays.asList(response.getBody());
	}

}
