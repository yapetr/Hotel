package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * 
 * Interface to access data of rooms
 * 
 */
public interface UserDao {
	
	/**
	 * Creates user in database based on data of User class object 
	 * @param user
	 */
	void create(User user);
	
	/**
	 * Deletes user with defied id in database
	 * 
	 * @param id - id of user to be deleted 
	 */
	void delete(int id);
	
	/**
	 * Checks if can user passed in parameter login to system
	 * based on user login name and password hash that contains 
	 * user object
	 * 
	 * @param user - checking user
	 * @return - result of checking login and password
	 */
	boolean login(User user);
	
	/**
	 * Checks if present in database user with defined login
	 * 
	 * @param user - checking user
	 * @return - result of checking
	 */
	boolean isLoginFree(User user);
	
	/**
	 * Returners list of all registered users
	 * 
	 * @return list of all users 
	 */
	List<User> findAll();
}
