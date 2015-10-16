package org.ekonopaka.crm.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	IUserService userService;

	@Override
	@Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		User user = (User) auth.getPrincipal();
		userService.saveLoginEntry(user);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
	}
}
