package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.UserDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;
import com.sun.org.apache.bcel.internal.util.Objects;

/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Invokes to register new user in data source
 */

public class RegisterCommand implements Command{
    
	private final static String PARAM_NAME_LOGIN = "login";
	private final static String PARAM_NAME_NAME = "name";
	private final static String PARAM_NAME_PASSWORD = "password";
	private final static String PARAM_NAME_EMAIL = "email";
	private final static String PARAM_NAME_CONFIRMPASSWORD = "confirmPassword";


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {


		String login = request.getParameter(PARAM_NAME_LOGIN);
		String name = request.getParameter(PARAM_NAME_NAME);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		String email = request.getParameter(PARAM_NAME_EMAIL);
		String confirmPassword = request.getParameter(PARAM_NAME_CONFIRMPASSWORD);
		
		String errorMessage = "";
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.createUserDao();
		
		User user = new User();
		user.setName(name);
		user.setLogin(login);
		user.setPasswordHash(password);
		user.setEmail(email);
		user.setAdministrator(false);
		
		if(!userDao.isLoginFree(user)){
			errorMessage += "Login занят \r\n" ;
		}
		
		if(password.length() < 5){
			errorMessage += "Длина прароля меньше 5 символов \r\n";
		}
		
		
		if(!Objects.equals(password,confirmPassword)){
			errorMessage += "Пароль и подтверждение пароля не совпадают \r\n";
		}
		

		
		
		if("".equals(errorMessage)){	
			userDao.create(user);
			return ConfigurationManager.getProperty("path.page.index");
		}
		
	
		
		request.setAttribute("errorMessage", errorMessage);
		return  ConfigurationManager.getProperty("path.page.registration"); 
		

		
	}
    
}
