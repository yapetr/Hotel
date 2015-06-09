package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Inerface for all classes which invokes servlet EngineServlet. 
 * 
 */

public interface Command {
	
        String execute(HttpServletRequest request , HttpServletResponse response);

}
