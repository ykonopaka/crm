package org.ekonopaka.crm.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.Attachment;
import org.ekonopaka.crm.service.interfaces.IAttachmentService;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService implements IAttachmentService {

	@Override
	public List<Attachment> getFiles(int dealId, String basePath) {
		String directoryPath = basePath + File.separator + IAttachmentService.UPLOAD_DIR + File.separator + dealId + File.separator + IAttachmentService.FILES_DIR;
		
		File dir = new File(directoryPath);
		
		File[] files = dir.listFiles();
		
		List<Attachment> attachments = new ArrayList<Attachment>();
		
		if (files != null)	{
			for (File f : files)	{
				Attachment attachment = new Attachment();
				attachment.setFile(f);
				attachments.add(attachment);
			}
		}
		
		return attachments;
	}

	@Override
	public List<Attachment> getDocs(int dealId, String basePath) {
		String directoryPath = basePath + File.separator + IAttachmentService.UPLOAD_DIR + File.separator + dealId + File.separator + IAttachmentService.DOCS_DIR;
		
		File dir = new File(directoryPath);
		
		File[] files = dir.listFiles();
		
		List<Attachment> attachments = new ArrayList<Attachment>();
		
		if (files != null)	{
			for (File f : files)	{
				Attachment attachment = new Attachment();
				attachment.setFile(f);
				attachments.add(attachment);
			}
		}
		
		return attachments;
	}

}
