package com.stepan.relations.core.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stepan.relations.core.model.EntityR;
import com.stepan.relations.core.model.RelationshipR;

public interface RelationshipRRepo extends JpaRepository<RelationshipR, Long> {

	@Query("select r from RelationshipR r LEFT JOIN FETCH r.entities where r.relationshipUUID = ?1")
	RelationshipR inflatedRelationshipByUuid(UUID uuid);
}
