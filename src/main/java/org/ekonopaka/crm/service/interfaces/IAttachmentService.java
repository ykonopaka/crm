package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Attachment;

public interface IAttachmentService {

	public static final String UPLOAD_DIR = "uploads";
	public static final String FILES_DIR = "files";
	public static final String DOCS_DIR = "docs";
	
	public List<Attachment> getFiles(int dealId, String basePath);
	public List<Attachment> getDocs(int dealId, String basePath);
	
}
