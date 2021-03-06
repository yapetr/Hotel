package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.UserDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to delete User item from data source
 * 
 */

public class DeleteUserCommand implements Command {

	public static final String PARAM_NAME_ID = "id";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String sId = request.getParameter(PARAM_NAME_ID); 
		int id = Integer.parseInt(sId);
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao user = daoFactory.createUserDao();
		
		user.delete(id);
		
		return ConfigurationManager.getProperty("path.page.users");
	}

}
