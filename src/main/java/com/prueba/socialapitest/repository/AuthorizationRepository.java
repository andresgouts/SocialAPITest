package com.prueba.socialapitest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.socialapitest.entity.AuthorizationEntity;

@Repository
public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, Long> {

	List<AuthorizationEntity> findByAlbumId(long albumId);
	
	@Query(value = "SELECT a FROM AuthorizationEntity a " + "WHERE a.albumId = :albumId"
            + " AND a.userId = :userId")
	AuthorizationEntity findByAlbumAndUser(@Param(value = "albumId") long albumId, @Param(value = "userId") long userId);
}
