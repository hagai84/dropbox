package com.hagaisapir.dropbox.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hagaisapir.dropbox.server.entities.FileEntity;

@Repository
public class FileDao {
	@PersistenceContext(unitName="dropboxDb")
	private EntityManager entityManager;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createFile(FileEntity fileEntity){
		entityManager.persist(fileEntity);
	}
}
