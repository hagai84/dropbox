package com.hagaisapir.dropbox.dropboxserver.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hagaisapir.dropbox.dropboxserver.dao.FileDao;
import com.hagaisapir.dropbox.dropboxserver.entities.FileEntity;

@Controller
public class FileLogic {

	@Autowired
	private FileDao fileDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void createFile(FileEntity fileEntity) {
		fileDao.createFile(fileEntity);
	}

}
