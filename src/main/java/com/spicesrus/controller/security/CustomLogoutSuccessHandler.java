package com.spicesrus.controller.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.spicesrus.service.CartHelper;

@Component
public class CustomLogoutSuccessHandler  extends
SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			request.getSession().invalidate();
			response.sendRedirect("/");
			CartHelper.setCartSize(0);
	        super.onLogoutSuccess(request, response, authentication);			
	}
	


}
