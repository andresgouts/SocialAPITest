package com.prueba.socialapitest.repository;

import java.util.List;

import com.prueba.socialapitest.domain.Comment;

public interface CommentRepository {
	
	List<Comment> findAll();
	
	List<Comment> findByEmail(String userId);	
}
