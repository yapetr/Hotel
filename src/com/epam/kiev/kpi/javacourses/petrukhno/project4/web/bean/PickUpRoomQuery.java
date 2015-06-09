package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Room;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Beam class contains methods which allows to set order parametr 
 * from JSP page and receive list of sutable rooms  
 * 
 */

public class PickUpRoomQuery {
	
	private Order order;
	
	/**
	 * 
	 * @return list of sutable rooms
	 */
	public List<Room> getRoomsList(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		RoomDao roomDao = daoFactory.createRoomDao();
		return  roomDao.findFree(order);			
	}

	
	/**
	 * 
	 * @param client's order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	

}
