package com.prueba.socialapitest.domain;

public class Comment {
	private long PostId;
	private long id;
	private String name;
	private String email;
	private String body;
	
	public long getPostId() {
		return PostId;
	}
	public void setPostId(long postId) {
		PostId = postId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
