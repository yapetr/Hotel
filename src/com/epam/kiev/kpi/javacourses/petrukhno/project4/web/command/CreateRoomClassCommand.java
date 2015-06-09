package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomClassDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to create new class room item in data source
 * 
 */

public class CreateRoomClassCommand implements Command {
	
	public static final String PARAM_NAME_NAME = "name";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String name = request.getParameter(PARAM_NAME_NAME); 
		DaoFactory daoFactory = DaoFactory.getInstance();
		RoomClassDao roomClassDao = daoFactory.createRoomClassDao();
		
		RoomClass roomClass = new RoomClass();
		roomClass.setName(name);
		
		roomClassDao.create(roomClass);
		
		return ConfigurationManager.getProperty("path.page.roomclass");
	}
}
