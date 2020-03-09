package com.prueba.socialapitest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.socialapitest.domain.Comment;
import com.prueba.socialapitest.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("")
	public List<Comment> searchComments(@RequestBody Comment comment){
		return commentService.serchComments(comment);
	}

}
