package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.OrderDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which contains method that allows to receive list of all
 * unprocessed orders from JSP and find order among all 
 * unprocessed orders by it's id
 *
 */

public class UnprocessedOrdersQuery {
    
	List<Order> orders;
	int orderId;
	
	/**
	 * Constructor queries all unprocessed orders 
	 */
	public UnprocessedOrdersQuery() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		OrderDao orderDao = daoFactory.createOrderDao();
		orders = orderDao.findUnprocessed();		
	}

    /**
     * 
     * @return all unprocessed orders
     */
	public List<Order> getUnprocessedOrders(){
		return orders;
    }

    /**
     * 
     * @param set up id order to find
     */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	/**
	 * 
	 * @return order with setted id
	 */
	public Order getOrder(){
		for(Order order: orders){
			if(order.getId() == orderId){
				return order;
			}
		}
		return null;
	}
	
	
	
}
