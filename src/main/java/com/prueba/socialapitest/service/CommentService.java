package com.prueba.socialapitest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.socialapitest.domain.Comment;
import com.prueba.socialapitest.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> serchComments(Comment comment){
		List<Comment> comments = new ArrayList<>();
		if(comment.getEmail() != null) {
			comments = findByEmail(comment.getEmail());
		}else {
			comments = findAll();
		}
		if(comment.getName() != null) {
			return comments.stream().filter(x -> x.getName().equals(comment.getName()))
					.collect(Collectors.toList());
		}
		return comments;
	}
	
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
	public List<Comment> findByEmail(String email){
		return commentRepository.findByEmail(email);
	}
}
