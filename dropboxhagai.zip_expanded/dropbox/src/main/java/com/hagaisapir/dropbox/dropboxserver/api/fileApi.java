package com.hagaisapir.dropbox.dropboxserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hagaisapir.dropbox.dropboxserver.entities.FileEntity;
import com.hagaisapir.dropbox.dropboxserver.logic.FileLogic;

@RestController
@RequestMapping(value = "/file")

public class fileApi {

	@Autowired
	private FileLogic fileLogic;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void upkoadFile(@RequestBody FileEntity fileEntity) {
		System.out.println("file api executed");
		fileLogic.createFile(fileEntity);
	}
}
