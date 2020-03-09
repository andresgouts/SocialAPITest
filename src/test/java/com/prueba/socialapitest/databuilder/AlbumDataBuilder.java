package com.prueba.socialapitest.databuilder;

import com.prueba.socialapitest.domain.Album;

public class AlbumDataBuilder {
	private long userId;
	private long id;
	private String title;
	
	
	public AlbumDataBuilder() {
		this.userId = 1;
		this.id = 1;
		this.title = "title";
	}	
	
	public AlbumDataBuilder withUserId(long userId) {
		this.userId = userId;
		return this;
	}
	
	public Album build() {
		Album album = new Album();
		album.setId(id);
		album.setTitle(title);
		album.setUserId(userId);
		return album;
	}
}
