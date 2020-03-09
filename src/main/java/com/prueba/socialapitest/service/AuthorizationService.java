package com.prueba.socialapitest.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.socialapitest.Exception.BadRequestException;
import com.prueba.socialapitest.Exception.NotFoundException;
import com.prueba.socialapitest.domain.Album;
import com.prueba.socialapitest.domain.Authorization;
import com.prueba.socialapitest.domain.User;
import com.prueba.socialapitest.entity.AuthorizationEntity;
import com.prueba.socialapitest.repository.AlbumRepository;
import com.prueba.socialapitest.repository.AuthorizationRepository;
import com.prueba.socialapitest.repository.UserRepository;

@Service
public class AuthorizationService {
	
	@Autowired
	private AuthorizationRepository authorizationRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
		
	public AuthorizationService(AuthorizationRepository authorizationRepository, AlbumRepository albumRepository,
			UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.authorizationRepository = authorizationRepository;
		this.albumRepository = albumRepository;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public Authorization createAuthorization(Authorization autorization) throws BadRequestException, NotFoundException {
		Album album = albumRepository.albumById(autorization.getAlbumId());
		if(album != null) {
			if(album.getUserId() == autorization.getUserId())
				throw new BadRequestException("Error con usuario de permiso");
			User user = userRepository.userById(autorization.getUserId());
			if(user == null)
				throw new NotFoundException("Usuario no encontrado");
		} else {
			throw new NotFoundException("Album no encontrado");
		}
		AuthorizationEntity authorizationEntity = convertToEntity(autorization);
		try {
			authorizationEntity = authorizationRepository.save(authorizationEntity);
		} catch (Exception jdbcSQLIntegrityConstraintViolationException) {
			throw new BadRequestException("Ya Existe un permiso asignado para el album al usuario");
		}
		return convertToDomain(authorizationEntity);
		
	}
	
	public Authorization updateAuthorization(Authorization authorization) throws NotFoundException {
		AuthorizationEntity actualAuthorization = authorizationRepository.
				findByAlbumAndUser(authorization.getAlbumId(), authorization.getUserId());
		if(actualAuthorization == null) 
			throw new NotFoundException("No se ha asignado aun un permiso para ese album con el usuario indicado");
		actualAuthorization.setAuthorizationType(authorization.getAuthorizationType());
		actualAuthorization = authorizationRepository.save(actualAuthorization);
		return convertToDomain(actualAuthorization);
	}
	
	public List<Authorization> findByAlbumId(long albumId){
		List<Authorization> authorizations = new ArrayList<>();
		authorizationRepository.findByAlbumId(albumId).stream().map(this::convertToDomain).
			forEach(x -> authorizations.add(x));
		return authorizations;
	}

	public Authorization convertToDomain(AuthorizationEntity authorizationEntity) {
		return modelMapper.map(authorizationEntity, Authorization.class);
	}

	public AuthorizationEntity convertToEntity(Authorization autorization) {
		return modelMapper.map(autorization, AuthorizationEntity.class);
	}
}
