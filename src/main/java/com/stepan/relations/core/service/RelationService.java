package com.stepan.relations.core.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.stepan.relations.core.model.EntityR;
import com.stepan.relations.core.model.RelationshipR;
import com.stepan.relations.core.model.repo.EntityRRepo;
import com.stepan.relations.core.model.repo.RelationshipRRepo;

@Service
public class RelationService {
	
	@Autowired
	EntityRRepo entRepo;
	
	@Autowired
	RelationshipRRepo relRepo;
	
	public RelationshipR createRelationship(UUID uuid){
		return relRepo.saveAndFlush(new RelationshipR(uuid));
	}
	
	public EntityR createEntity(UUID uuid){
		return entRepo.saveAndFlush(new EntityR(uuid));
	}
	
	public RelationshipR addEntityTo(RelationshipR rel, EntityR ent){
		
		Assert.notNull(rel, "relationship cannot be null");
		Assert.notNull(rel.getId(), "relationship id cannot be null");
		Assert.notNull(ent, "entity cannot be null");
		Assert.notNull(ent.getId(), "entity id cannot be null");
		ent.getRelationships().add(rel);
		rel.getEntities().add(ent);
		
		return relRepo.saveAndFlush(rel);

	}
	
	public RelationshipR relationshipWith(UUID entId, UUID relId){
		return entRepo
				.inflatedEntityByUuid(entId)
				.getRelationships()
				.stream()
				.filter(r -> r.getRelationshipUUID().equals(relId))
				.findAny()
				.orElseGet(() -> new RelationshipR());
	}
	
	
	
	

}
