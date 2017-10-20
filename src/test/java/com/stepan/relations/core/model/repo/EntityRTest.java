package com.stepan.relations.core.model.repo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stepan.relations.core.model.EntityR;
import com.stepan.relations.core.model.RelationshipR;
import com.stepan.relations.core.service.RelationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityRTest {
	
	@Autowired
	EntityRRepo entRepo;
	
	@Autowired
	RelationshipRRepo relRepo;
	
	@Autowired
	RelationService service;
	
	@Test
	public void shouldSave(){
		EntityR ent = new EntityR();
		ent.setEntityUUID(UUID.randomUUID());
		RelationshipR rel = new RelationshipR();
		rel = relRepo.saveAndFlush(rel);
		System.out.println(entRepo.saveAndFlush(ent));
	}
	
	

}
