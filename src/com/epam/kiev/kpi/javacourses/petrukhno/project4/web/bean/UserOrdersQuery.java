package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.OrderDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which contains methods that allows to receive list of
 * processed orders of defined user from JSP
 *
 */
public class UserOrdersQuery {
	
	private User user;

	/**
	 * 
	 * @param user to filter orders
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return list of processed orders by user
	 */
	public List<Order> getOrdersByUser(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		OrderDao orderDao = daoFactory.createOrderDao();
		return  orderDao.findByUser(user);			
	}

}
