package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

public class SetLocale implements Command {

	public static final String PARAM_NAME_LOCALE = "locale";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String language = request.getParameter(PARAM_NAME_LOCALE);
		Locale locale = new Locale(language);
		Config.set(session, Config.FMT_LOCALE, locale);
		
		return ConfigurationManager.getProperty("path.page.index");
	}

}
