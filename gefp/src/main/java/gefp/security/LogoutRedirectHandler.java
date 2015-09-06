/*
 * This file is part of the CSNetwork Services (CSNS) project.
 * 
 * Copyright 2012, Chengyu Sun (csun@calstatela.edu).
 * 
 * CSNS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * CSNS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with CSNS. If not, see http://www.gnu.org/licenses/agpl.html.
 */
package gefp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import gefp.model.User;
import gefp.model.dao.UserDao;

@Component
public class LogoutRedirectHandler implements LogoutSuccessHandler {

	@Autowired
	private UserDao userDao;
	
	String send = "";

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// authentication could be null if the session already expired or the
		// user clicked the logout link twice.
		UserDetails u = (UserDetails) authentication.getPrincipal();
		User user=userDao.getuser(u.getUsername());

		if (user.getUserrole().getType().equalsIgnoreCase("administrators")) {
			SimpleUrlLogoutSuccessHandler logoutSuccessHandler = new SimpleUrlLogoutSuccessHandler();
			send="/admin/logout.html";
			logoutSuccessHandler.setDefaultTargetUrl(send);
			logoutSuccessHandler.onLogoutSuccess(request, response,authentication);
		}
		if (user.getUserrole().getType().equalsIgnoreCase("advisors")) {
			SimpleUrlLogoutSuccessHandler logoutSuccessHandler = new SimpleUrlLogoutSuccessHandler();
			send="/advisor/logout.html";
			logoutSuccessHandler.setDefaultTargetUrl(send);
			logoutSuccessHandler.onLogoutSuccess(request, response,authentication);
		}
		if (user.getUserrole().getType().equalsIgnoreCase("students")) {
			SimpleUrlLogoutSuccessHandler logoutSuccessHandler = new SimpleUrlLogoutSuccessHandler();
			send="/student/logout.html";
			logoutSuccessHandler.setDefaultTargetUrl(send);
			logoutSuccessHandler.onLogoutSuccess(request, response,authentication);
		}
	}

}
