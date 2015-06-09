package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Room;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which contains method that allows to receive list of all
 * rooms from JSP
 *
 */
public class RoomsQuery {
	
	/**
	 * 
	 * @return list of all rooms
	 */
	public List<Room> getRoomsList(){		
		DaoFactory daoFactory = DaoFactory.getInstance();
		RoomDao roomDao = daoFactory.createRoomDao();
		return  roomDao.findAll();				
	}

}
