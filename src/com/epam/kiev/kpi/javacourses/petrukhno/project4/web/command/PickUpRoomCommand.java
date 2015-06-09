package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;


/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Invokes to choose suitable room according to defined order
 * 
 */

public class PickUpRoomCommand implements Command {

	public static final String PARAM_NAME_ORDER_ID = "id";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String orderIdStr = request.getParameter(PARAM_NAME_ORDER_ID);
		int orderId = Integer.parseInt(orderIdStr);
		request.setAttribute("processingOrderId", orderId);
		
		return ConfigurationManager.getProperty("path.page.unprocessedOrders");
	}

}
