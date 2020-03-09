package com.prueba.socialapitest.databuilder;

import com.prueba.socialapitest.domain.Authorization;
import com.prueba.socialapitest.entity.AuthorizationEntity;

public class AuthorizationDataBuilder {
	private long idAuthorization;
	private long albumId;
	private long userId;
	private char authorizationType;
	
	public AuthorizationDataBuilder() {
		this.idAuthorization = 1;
		this.albumId = 1;
		this.userId = 1;
		this.authorizationType = 'r';
	}
	
	public AuthorizationDataBuilder AuthorizationDataBuilderConId(long id) {
		this.idAuthorization = id;
		return this;
	}
	
	public AuthorizationDataBuilder AuthorizationDataBuilderAlbumId(long id) {
		this.albumId = id;
		return this;
	}
	
	public AuthorizationDataBuilder AuthorizationDataBuilderUserId(long id) {
		this.userId = id;
		return this;
	}
	
	public AuthorizationDataBuilder AuthorizationDataBuilderType(char type) {
		this.authorizationType = type;
		return this;
	}
	
	public Authorization build() {
		Authorization authorization = new Authorization();
		authorization.setAlbumId(albumId);
		authorization.setAuthorizationType(authorizationType);
		authorization.setIdAuthorization(idAuthorization);
		authorization.setUserId(userId);
		return authorization;
	}
	
	public AuthorizationEntity buildEntity() {
		AuthorizationEntity authorization = new AuthorizationEntity();
		authorization.setAlbumId(albumId);
		authorization.setAuthorizationType(authorizationType);
		authorization.setIdAuthorization(idAuthorization);
		authorization.setUserId(userId);
		return authorization;
	}
}
