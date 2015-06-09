package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.OrderDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Invokes to fill room in unprocessed order
 */

public class SetRoomCommand implements Command {

	public static final String PARAM_NAME_PROCESSING_ORDER = "processingOrder";
	public static final String PARAM_NAME_ROOM_ID = "roomId";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute(PARAM_NAME_PROCESSING_ORDER); 
		String roomIdStr = request.getParameter(PARAM_NAME_ROOM_ID);
		int roomId = Integer.valueOf(roomIdStr);
		session.removeAttribute(PARAM_NAME_PROCESSING_ORDER);
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		OrderDao orderDao = daoFactory.createOrderDao();
		orderDao.setRoom(order, roomId);		
		
		return ConfigurationManager.getProperty("path.page.unprocessedOrders");
	}

}
