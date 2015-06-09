package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomClassDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Tag which describes select room input
 */

@SuppressWarnings("serial")
public class RoomClassChoose extends TagSupport {


	@Override
	public int doStartTag() throws JspException {

		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			RoomClassDao roomClassDao = daoFactory.createRoomClassDao();
			List<RoomClass> roomClasses= roomClassDao.findAll();
					
			JspWriter out = pageContext.getOut();
			out.write("<select name=\"roomclass\">");
			for(RoomClass roomClass: roomClasses){
				out.write("<option value= " + roomClass.getId() + ">" + roomClass.getName() +"</option>");
			}
			out.write("</select>");
	
		} catch (IOException e) {
	    	
			Logger logger = LogManager.getLogger(RoomClassChoose.class.getName());
        	logger.error("Error creation election of room class " + e);
        	
		}
		
		return SKIP_BODY;
	}

}
