package com.hagaisapir.dropbox.server.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="files")
public class FileEntity {

	@Id
	@Column(name="filePath", nullable=false)
	private String filePath;
	@Column(name="fileData", nullable=false)
	private String fileData;
//	@Column(name="fileDate", nullable=false)
//	private Date fileDate;
	
	
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
//	public Date getFileDate() {
//		return fileDate;
//	}
//	public void setFileDate(Date fileDate) {
//		this.fileDate = fileDate;
//	}
	
	
 
}
