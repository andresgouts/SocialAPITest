package com.prueba.socialapitest.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.prueba.socialapitest.Exception.BadRequestException;
import com.prueba.socialapitest.Exception.NotFoundException;
import com.prueba.socialapitest.databuilder.AlbumDataBuilder;
import com.prueba.socialapitest.databuilder.AuthorizationDataBuilder;
import com.prueba.socialapitest.databuilder.UserDataBuilder;
import com.prueba.socialapitest.domain.Album;
import com.prueba.socialapitest.domain.Authorization;
import com.prueba.socialapitest.domain.User;
import com.prueba.socialapitest.entity.AuthorizationEntity;
import com.prueba.socialapitest.repository.AlbumRepository;
import com.prueba.socialapitest.repository.AuthorizationRepository;
import com.prueba.socialapitest.repository.UserRepository;
import com.prueba.socialapitest.service.AuthorizationService;

public class AuthorizationServiceTest {
	
	AuthorizationDataBuilder auDataBuilder = new AuthorizationDataBuilder();
	AlbumDataBuilder albumDataBuilder = new AlbumDataBuilder();
	UserDataBuilder userDataBuilder = new UserDataBuilder();
	
	@Mock
	AuthorizationRepository authorizationRepository;
	
	@Mock
	AlbumRepository albumRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	ModelMapper modelMapper;
	
	@InjectMocks
	AuthorizationService authorizationService;
	
	AuthorizationService authorizationServiceSpy;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		authorizationServiceSpy = Mockito.spy(authorizationService);
	}
	 
	@Test
	public void createAuthorizationAlbumErrorTest() {
		Authorization authorizationToSave = auDataBuilder.build();
		when(albumRepository.albumById(authorizationToSave.getAlbumId())).thenReturn(null);
		
		try {
			Authorization authorizationSaved = authorizationService.createAuthorization(authorizationToSave);
		} catch (BadRequestException e) {
			fail();
		} catch (NotFoundException e) {
			assertEquals("Album no encontrado", e.getMessage());
			return;
		}
		fail();
	}
	
	@Test
	public void createAuthorizationUsuerErrorTest() {
		Authorization authorizationToSave = auDataBuilder.build();
		Album album = albumDataBuilder.build();
		when(albumRepository.albumById(authorizationToSave.getAlbumId())).thenReturn(album);		
		try {
			Authorization authorizationSaved = authorizationService.createAuthorization(authorizationToSave);
		} catch (BadRequestException e) {
			assertEquals("Error con usuario de permiso", e.getMessage());
			return;
		} catch (NotFoundException e) {
			fail();
		}
		fail();
	}
	
	@Test
	public void createAuthorizationUsuerNotFoundTest() {
		Authorization authorizationToSave = auDataBuilder.build();
		Album album = albumDataBuilder.withUserId(2).build();
		when(albumRepository.albumById(authorizationToSave.getAlbumId())).thenReturn(album);
		when(userRepository.userById(authorizationToSave.getUserId())).thenReturn(null);
		try {
			Authorization authorizationSaved = authorizationService.createAuthorization(authorizationToSave);
		} catch (BadRequestException e) {
			fail();
		} catch (NotFoundException e) {
			assertEquals("Usuario no encontrado", e.getMessage());
			return;
		}
		fail();
	}
	
	@Test
	public void createAuthorizationSuccessTest() {
		Authorization authorization = new Authorization();
		Authorization authorizationToSave = auDataBuilder.build();
		AuthorizationEntity authorizationSaved = auDataBuilder.buildEntity();
		Album album = albumDataBuilder.withUserId(2).build();
		User user = userDataBuilder.withId(2).build();
		when(albumRepository.albumById(authorizationToSave.getAlbumId())).thenReturn(album);
		when(userRepository.userById(authorizationToSave.getUserId())).thenReturn(user);
		Mockito.doReturn(authorizationSaved).when(authorizationServiceSpy).convertToEntity(Mockito.any());
		Mockito.doReturn(authorizationToSave).when(authorizationServiceSpy).convertToDomain(Mockito.any());
		when(authorizationRepository.save(authorizationSaved)).thenReturn(authorizationSaved);
		try {
			authorization = authorizationServiceSpy.createAuthorization(authorizationToSave);
		} catch (BadRequestException e) {
			fail();
		} catch (NotFoundException e) {
			fail();
		}
		assertEquals(authorizationToSave.getIdAuthorization(), authorization.getIdAuthorization());
	}
}
