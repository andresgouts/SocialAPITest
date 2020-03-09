package com.prueba.socialapitest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Authorization", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"albumId", "userId"})})
public class AuthorizationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAuthorization;
	
	@Column(nullable = false)
	private long albumId;
	
	@Column(nullable = false)
	private long userId;
	
	@Column(nullable = false)
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
