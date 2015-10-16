package org.ekonopaka.crm.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.ekonopaka.crm.form.FileUploadForm;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IAttachmentService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController  {

	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	IUserService userService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
    @RequestMapping(value = "workflow/deal/{dealId}/files/upload", method = RequestMethod.GET)
    public String uploadFilesGet( Model model, @PathVariable int dealId) {
    	
		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		
		model.addAttribute("coordinatorOnly", coordinatorOnly);
    	model.addAttribute("uploadForm", new FileUploadForm());
        return "fileupload";
    }
    
    @RequestMapping(value = "workflow/deal/{dealId}/files/upload", method = RequestMethod.POST)
    public String uploadFilesPost(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model model, HttpServletRequest request, BindingResult result, @PathVariable int dealId, Locale locale) {
         
        MultipartFile multipartFile = uploadForm.getFile();
        
        if (multipartFile==null || multipartFile.getSize() == 0){
        	String msg = messageSource.getMessage("deal.upload.general.failure.message", null, locale);
        	
        	model.addAttribute("uploadForm", new FileUploadForm());
        	model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
            return "fileupload";
        }
 
        String orgName = multipartFile.getOriginalFilename();
        
        String absoluteBasePath = request.getSession().getServletContext().getRealPath("/");
        String directoryUploads = absoluteBasePath + File.separator + IAttachmentService.UPLOAD_DIR;
        String directoryPath = directoryUploads + File.separator + dealId;
        String directoryPathFiles = directoryPath + File.separator + IAttachmentService.FILES_DIR;
        String filePath = directoryPathFiles + File.separator + orgName;
        
        File uploads = new File(directoryUploads);
        File dir = new File(directoryPath);
        File filesDir = new File(directoryPathFiles);
        File dest = new File(filePath);
        
        if (dest.exists())	{
        	String msg = messageSource.getMessage("deal.upload.already.exists.failure.message", null, locale);
        	model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
        	model.addAttribute("uploadForm", uploadForm);
        	
        	return "fileupload";
        }
        
        try {
        	if (!uploads.exists())	{
        		uploads.mkdir();
        	}
        	if (!dir.exists())	{
        		dir.mkdir();
        	}
        	if (!filesDir.exists())	{
        		filesDir.mkdir();
        	}
        	dest.createNewFile();
            multipartFile.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e)	{
        	e.printStackTrace();
        }

		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		model.addAttribute("coordinatorOnly", coordinatorOnly);
        model.addAttribute("file", orgName);
        model.addAttribute("dealId", dealId);
        return "fileuploadsuccess";
    }
    
    @RequestMapping(value = "workflow/deal/{dealId}/docs/upload", method = RequestMethod.GET)
    public String uploadDocsGet( Model model, @PathVariable int dealId) {
    	
		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		
		model.addAttribute("coordinatorOnly", coordinatorOnly);
    	model.addAttribute("uploadForm", new FileUploadForm());
        return "docupload";
    }
    
    @RequestMapping(value = "workflow/deal/{dealId}/docs/upload", method = RequestMethod.POST)
    public String uploadDocsPost(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model model, HttpServletRequest request, BindingResult result, @PathVariable int dealId, Locale locale) {
         
        MultipartFile multipartFile = uploadForm.getFile();
        
        if (multipartFile==null || multipartFile.getSize() == 0){
        	String msg = messageSource.getMessage("deal.upload.general.failure.message", null, locale);
        	
        	model.addAttribute("uploadForm", new FileUploadForm());
        	model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
            return "docupload";
        }
 
        String orgName = multipartFile.getOriginalFilename();
        
        String absoluteBasePath = request.getSession().getServletContext().getRealPath("/");
        String directoryUploads = absoluteBasePath + File.separator + IAttachmentService.UPLOAD_DIR;
        String directoryPath = directoryUploads + File.separator + dealId;
        String directoryPathFiles = directoryPath + File.separator + IAttachmentService.DOCS_DIR;
        String filePath = directoryPathFiles + File.separator + orgName;
        
        File uploads = new File(directoryUploads);
        File dir = new File(directoryPath);
        File filesDir = new File(directoryPathFiles);
        File dest = new File(filePath);
        
        if (dest.exists())	{
        	String msg = messageSource.getMessage("deal.upload.already.exists.failure.message", null, locale);
        	model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
        	model.addAttribute("uploadForm", uploadForm);
        	
        	return "docupload";
        }
        
        try {
        	if (!uploads.exists())	{
        		uploads.mkdir();
        	}
        	if (!dir.exists())	{
        		dir.mkdir();
        	}
        	if (!filesDir.exists())	{
        		filesDir.mkdir();
        	}
        	dest.createNewFile();
            multipartFile.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e)	{
        	e.printStackTrace();
        }

		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		model.addAttribute("coordinatorOnly", coordinatorOnly);
        model.addAttribute("file", orgName);
        model.addAttribute("dealId", dealId);
        return "docuploadsuccess";
    }



    
}
