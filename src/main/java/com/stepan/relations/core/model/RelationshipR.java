package com.stepan.relations.core.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RelationshipR {

	
	@Id @GeneratedValue
	Long id;
	
	UUID relationshipUUID;
	
	@ManyToMany
	Set<EntityR> entities = new HashSet<>();

	public RelationshipR(UUID uuid) {
		relationshipUUID = uuid;
	}
	
	public RelationshipR() {}

	public Long getId() {
		return id;
	}

	public UUID getRelationshipUUID() {
		return relationshipUUID;
	}

	public Set<EntityR> getEntities() {
		return entities;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRelationshipUUID(UUID relationshipUUID) {
		this.relationshipUUID = relationshipUUID;
	}

	public void setEntities(Set<EntityR> entities) {
		this.entities = entities;
	}
	
	
	
}
