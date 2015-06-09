package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.PriceDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Price;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Invokes to store price list in data source
 * 
 */

public class SetPriceListCommand implements Command {

	public static final String PARAM_NAME_ROOMCLASS_ID = "roomClassId";
	public static final String PARAM_NAME_BEDS = "beds";
	public static final String PARAM_NAME_PRICE = "price";
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Price> lst = new ArrayList<>();
		
		int count = 1;
		
		String roomClassIdStr = request.getParameter(PARAM_NAME_ROOMCLASS_ID + count); 
		String bedsStr = request.getParameter(PARAM_NAME_BEDS + count); 
		String priceStr = request.getParameter(PARAM_NAME_PRICE + count); 
		while(roomClassIdStr != null){
			
			int roomClassId = Integer.parseInt(roomClassIdStr);
			RoomClass roomClass = new RoomClass();
			roomClass.setId(roomClassId);
			
			int beds = Integer.parseInt(bedsStr);
			int priceValue = (int) (Double.valueOf(priceStr) * 100);
			Price price = new Price();
			price.setBeds(beds);
			price.setPrice(priceValue);
			price.setRoomClass(roomClass);
			
			lst.add(price);	
			
			count++;
			roomClassIdStr = request.getParameter(PARAM_NAME_ROOMCLASS_ID + count); 
			bedsStr = request.getParameter(PARAM_NAME_BEDS + count); 
			priceStr = request.getParameter(PARAM_NAME_PRICE + count);
		}
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		PriceDao priceDao = daoFactory.createPriceDao();
		priceDao.setPriceList(lst);
		
		return ConfigurationManager.getProperty("path.page.price");
	}

}
