package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Room;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to create new room in data source 
 */

public class CreateRoomCommand implements Command {
	
	public static final String PARAM_NAME_NUMBER = "number";
	public static final String PARAM_NAME_BEDS = "beds";
	public static final String PARAM_NAME_ROOM_CLASS_ID = "roomclass";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String number = request.getParameter(PARAM_NAME_NUMBER); 
		String beds = request.getParameter(PARAM_NAME_BEDS); 
		String roomClassId = request.getParameter(PARAM_NAME_ROOM_CLASS_ID); 
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		RoomDao roomDao = daoFactory.createRoomDao();
		
		try{
			
			RoomClass roomClass = new RoomClass();
			roomClass.setId(Integer.parseInt(roomClassId));
		
			Room room = new Room();
			room.setBeds(Integer.parseInt(beds));
			room.setNumber(Integer.parseInt(number));
			room.setRoomClass(roomClass);
			
			roomDao.create(room);
			
		} catch (NumberFormatException e) {
			
			Logger logger = LogManager.getLogger(CreateRoomCommand.class.getName());
        	logger.error("Error creation room " + e);	
        	
		}
			
		return ConfigurationManager.getProperty("path.page.rooms");
	}

}
