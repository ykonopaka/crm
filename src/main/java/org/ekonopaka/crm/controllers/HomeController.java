package org.ekonopaka.crm.controllers;

import java.util.Locale;

import org.apache.velocity.app.VelocityEngine;
import org.ekonopaka.crm.handlers.EmailHandler;
import org.ekonopaka.crm.init.InitConfigurator;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IInfoSourceService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	IUserService userService;

	@Autowired
	IInfoSourceService infoSourceService;

	@Autowired
	InitConfigurator initConfigurator;

	@Autowired
	JavaMailSenderImpl sender;

	@Autowired
	VelocityEngine velocityEngine;

	@Autowired
	EmailHandler emailHandler;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/")
	public String displayHome() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index")
	public String index() {
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		
		if (user.getIsOperator() || user.getIsCoordinator())
			return "redirect:/dashboard/mydeals";
		else 
			return "administration";
	}

	@RequestMapping(value = "/login*")
	public String login(Model model,
			@RequestParam(value = "msg", required = false) String loginError,
			Locale locale) {

		if (loginError != null) {
			String error = null;
			if (loginError.contains("badCredentials")) {
				error = messageSource.getMessage(
						"message.incorrect.credentials", null, locale);
			} else if (loginError.contains("credentialsExpired")) {
				error = messageSource.getMessage("message.expired.credentials",
						null, locale);
			} else if (loginError.contains("accountLocked")) {
				error = messageSource.getMessage("message.locked.account",
						null, locale);
			} else if (loginError.contains("accountDisabled")) {
				error = messageSource.getMessage("message.disabled.account",
						null, locale);
			} else if (loginError.contains("sessionExpired")) {
				error = messageSource.getMessage("message.session.expired",
						null, locale);
			}
			model.addAttribute("msg", error);
		}
		return "login";
	}

	@RequestMapping(value = "/administration")
	public String administration() {
		return "administration";
	}

	@RequestMapping(value = "/reports")
	public String reports() {
		return "reports";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {
		return "redirect:/dashboard/mydeals";
	}
	


	@RequestMapping(value = "/workflow")
	public String workflow() {
		return "workflow";
	}
}
