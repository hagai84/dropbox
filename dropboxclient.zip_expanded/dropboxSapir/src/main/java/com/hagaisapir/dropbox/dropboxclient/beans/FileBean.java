package com.hagaisapir.dropbox.dropboxclient.beans;

import java.io.File;

public class FileBean {
	
	private String filePath;
	private String fileData;
	
	
	public FileBean(String filePath, String fileData) {
		super();
		this.fileData = fileData;
		this.filePath = filePath;
	}
	public String getFileData() {
		return fileData;
	}
	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	


}
