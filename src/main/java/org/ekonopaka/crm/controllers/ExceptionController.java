package org.ekonopaka.crm.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.ekonopaka.crm.form.FileUploadForm;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.service.interfaces.IExceptionService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Controller
public class ExceptionController implements HandlerExceptionResolver {

	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CookieLocaleResolver cookieLocaleResolver;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IExceptionService exceptionService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception exception) {
        Map<String, Object> model = new HashMap<String, Object>();
        
        if (exception instanceof MaxUploadSizeExceededException)	{
        	String msg = messageSource.getMessage("deal.upload.size.too.big.failure.message", null, cookieLocaleResolver.resolveLocale(request));
        	model.put("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
            model.put("uploadForm", new FileUploadForm());
            return new ModelAndView("fileupload", model);
        } else	{
        	exception.printStackTrace();
        	logger.error(exception);
        	String msg = messageSource.getMessage("general.failure.message", null, cookieLocaleResolver.resolveLocale(request));
        	
        	model.put("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
        	model.put("exception", exceptionService.transformException(exception));

            return new ModelAndView("generalfailure", model);
        }

	}
}
