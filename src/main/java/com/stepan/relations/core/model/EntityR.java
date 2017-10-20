package com.stepan.relations.core.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EntityR {
	
	@Id @GeneratedValue
	Long id;
	
	UUID entityUUID;
	
	@ManyToMany(mappedBy="entities")
	Set<RelationshipR> relationships = new HashSet<>();

	public EntityR(UUID uuid) {
		entityUUID = uuid;
	}
	
	public EntityR() {}

	public Long getId() {
		return id;
	}

	public UUID getEntityUUID() {
		return entityUUID;
	}

	public Set<RelationshipR> getRelationships() {
		return relationships;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEntityUUID(UUID entityUUID) {
		this.entityUUID = entityUUID;
	}

	public void setRelationships(Set<RelationshipR> relationships) {
		this.relationships = relationships;
	}

	@Override
	public String toString() {
		return "EntityR [id=" + id + ", entityUUID=" + entityUUID + "]";
	}
	
	

}
