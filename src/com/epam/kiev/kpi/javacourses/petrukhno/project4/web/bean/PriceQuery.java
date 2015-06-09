package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.PriceDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Price;



/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean class which contains method that allows to receive price list 
 * from JSP
 *
 */

public class PriceQuery {
	
	/**
	 * Makes query to data source and receives price list
	 * @return price list
	 */
	public List<Price> getPriceList(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		PriceDao priceDao = daoFactory.createPriceDao();
		return  priceDao.findAll();			
	}
}
