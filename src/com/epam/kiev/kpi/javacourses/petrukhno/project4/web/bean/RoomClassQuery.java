package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomClassDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which contains method that allows receive list of 
 * room classes from JSP
 *
 */
public class RoomClassQuery  {

	/**
	 * 
	 * @return list of room classes
	 */
	public List<RoomClass> getRoomClassList(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		RoomClassDao roomClassDao = daoFactory.createRoomClassDao();
		return  roomClassDao.findAll();			
	}
}
