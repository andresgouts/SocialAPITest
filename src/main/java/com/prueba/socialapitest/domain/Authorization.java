package com.prueba.socialapitest.domain;

public class Authorization {
	
	private long idAuthorization;
	private long albumId;
	private long userId;
	private char authorizationType;
	public long getIdAuthorization() {
		return idAuthorization;
	}
	public void setIdAuthorization(long idAuthorization) {
		this.idAuthorization = idAuthorization;
	}
	public long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public char getAuthorizationType() {
		return authorizationType;
	}
	public void setAuthorizationType(char authorizationType) {
		this.authorizationType = authorizationType;
	}	
}
