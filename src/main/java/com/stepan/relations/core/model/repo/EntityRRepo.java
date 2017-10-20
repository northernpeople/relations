package com.stepan.relations.core.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stepan.relations.core.model.EntityR;

public interface EntityRRepo extends JpaRepository<EntityR, Long>{

	@Query("select e from EntityR e LEFT JOIN FETCH e.relationships where e.entityUUID = ?1")
	EntityR inflatedEntityByUuid(UUID uuid);
}
