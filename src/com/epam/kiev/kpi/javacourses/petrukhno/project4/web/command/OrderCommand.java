package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.OrderDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.User;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Invokes to create order item in data source
 * 
 */

public class OrderCommand implements Command{

	public static final String PARAM_NAME_ARRIVAL = "arraival";
	public static final String PARAM_NAME_DEPARTURE = "departure";
	public static final String PARAM_NAME_ROOMCLASS = "roomclass";
	public static final String PARAM_NAME_PERSONS = "persons";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date arraival = null;
		int roomClass_id = 0;
		Date departure = null;
		int persons = 0;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Locale locale = (Locale) Config.get(session, Config.FMT_LOCALE);		
		ResourceBundle resourses = null;
		if(locale == null){
			resourses = ResourceBundle.getBundle("com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.Resourses");
		} else {	
			resourses = ResourceBundle.getBundle("com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.Resourses", locale);
		}
		
		
		try {
			arraival = format.parse(request.getParameter(PARAM_NAME_ARRIVAL));
			roomClass_id = Integer.parseInt(request.getParameter(PARAM_NAME_ROOMCLASS));
			departure = format.parse(request.getParameter(PARAM_NAME_DEPARTURE));
			persons = Integer.parseInt(request.getParameter(PARAM_NAME_PERSONS));
			
			RoomClass roomClass = new RoomClass();
			roomClass.setId(roomClass_id);
			
			Order order = new Order();
			order.setBeds(persons);
			order.setArraival(arraival);
			order.setDeparture(departure);
			order.setRoomClass(roomClass);
			order.setUser(user);
			
			DaoFactory daoFactory = DaoFactory.getInstance();
			OrderDao orderDao = daoFactory.createOrderDao();
			orderDao.create(order);
			
			request.setAttribute("acceptOrderMessage", resourses.getObject("user.label.accepted"));
			
		} catch (NumberFormatException |ParseException e) {
			
			request.setAttribute("acceptOrderMessage", resourses.getObject("user.label.incorrectData"));
			Logger logger = LogManager.getLogger(OrderCommand.class.getName());
        	logger.error("Error creation election of room class " + e);
        	
		}		
		return ConfigurationManager.getProperty("path.page.user");
	}

}
