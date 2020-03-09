package com.prueba.socialapitest.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.prueba.socialapitest.domain.Comment;
import com.prueba.socialapitest.util.ConstantUtil;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@Override
	public List<Comment> findAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Comment[]> response = template.getForEntity(
				ConstantUtil.TYPECODE_URL + ConstantUtil.COMMENTS_PATH, Comment[].class);
		return Arrays.asList(response.getBody());
	}

	@Override
	public List<Comment> findByEmail(String userId) {
		RestTemplate template = new RestTemplate();
		String url = ConstantUtil.TYPECODE_URL + ConstantUtil.COMMENTS_PATH + 
		"?email=" + userId;
		ResponseEntity<Comment[]> response = template.getForEntity(url, Comment[].class);
		return Arrays.asList(response.getBody());
	}

}
