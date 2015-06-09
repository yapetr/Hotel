package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.UserDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to check user login and password and if prosessed
 * setup session user variable
 * 
 */

public class LoginCommand implements Command {
    
	public static final String PARAM_NAME_LOGIN = "login";
	public static final String PARAM_NAME_PASSWORD = "password";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
    	Logger logger = LogManager.getLogger(LoginCommand.class.getName());		
		
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
	
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.createUserDao();
		
		User user = new User();
		user.setLogin(login);
		user.setPasswordHash(password);
		
		if(!userDao.login(user)){
	    	
	    	logger.warn("User " + login + " access denied ");
	    	
			request.setAttribute("errorMessage", "Неправильный login или пароль");
			return ConfigurationManager.getProperty("path.page.index");
		}
		

    	logger.info("User " + user + " login ");	
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", user);

		
		if(user.getAdministrator()){
		
			return ConfigurationManager.getProperty("path.page.admin");
			
		} else {
			
			
			return ConfigurationManager.getProperty("path.page.user");
		}
	}
	

}
