package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomClassDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to delete room class iem from data source
 */

public class DeleteRoomClassCommand implements Command {
    
	public static final String PARAM_NAME_ID = "id";
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		try{
			
			String sId = request.getParameter(PARAM_NAME_ID); 
			int id = Integer.parseInt(sId);
			DaoFactory daoFactory = DaoFactory.getInstance();
			RoomClassDao roomClassDao = daoFactory.createRoomClassDao();
			
			roomClassDao.delete(id);
			
		} catch (NumberFormatException e){
			
			Logger logger = LogManager.getLogger(DeleteRoomClassCommand.class.getName());
        	logger.error("Error creation room " + e);
        	
		}

		
		return ConfigurationManager.getProperty("path.page.roomclass");
	}

}
