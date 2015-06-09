package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Invokes to show user all rooms
 *  
 */

public class RoomsCatalogCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		return ConfigurationManager.getProperty("path.page.rooms");
	}

}
