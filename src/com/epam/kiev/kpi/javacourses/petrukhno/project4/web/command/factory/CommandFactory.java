package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.Command;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Command factory class. Takes parameter command from request and creates
 * appropriate  command
 */

public class CommandFactory {
    public Command defineCommand(HttpServletRequest request){
    	Command current = null;
    	String action = request.getParameter("command");
    	if(action != null){
    		try{
    			CommandEnum currenEnum = CommandEnum.valueOf(action.toUpperCase());
    			current = currenEnum.getCurrentCommand();
    			return current;
    		} catch (IllegalArgumentException e){
    	    	Logger logger = LogManager.getLogger(CommandFactory.class.getName());
            	logger.error("Incorrect command " + e);	   			
    		}
    	}
    	return current;
    }
}
