package org.ekonopaka.crm.model;

import java.io.File;

public class Attachment {

	File file;
	String fileName;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
		this.setFileName(file.getName());
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
