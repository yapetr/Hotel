package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.UserDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which contains method that allows to receive list of all
 * users from JSP
 *
 */
public class UsersQuery {

	/**
	 * 
	 * @return list of all users
	 */
	public List<User> getUsersList(){		
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.createUserDao();
		return  userDao.findAll();				
	}
}
