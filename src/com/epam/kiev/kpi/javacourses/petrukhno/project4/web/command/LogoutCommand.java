package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to invalidate session
 * 
 */

public class LogoutCommand implements Command{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		request.getSession().invalidate();
		return ConfigurationManager.getProperty("path.page.index");
	}
	
}
