package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Price;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * 
 * Interface to access data of prices
 * 
 */

public interface PriceDao {
	
	/**
	 * Returns price of rooms with defined room class and defined 
	 * count of beds 
	 * 
	 * @param roomClass - class of room
	 * @param beds - count of beds
	 * @return price - price multiplied on 100
	 *   
	 */	
	int getPrice(RoomClass roomClass, int beds);
	
	/**
	 * Finds all possible prices which can be in addiction
	 * of current classes of rooms and count of beds in them
	 * 
	 * @return prices
	 */
	List<Price> findAll();
	
	/**
	 * Sets prices for all rooms. Before setting old price list removing
	 * 
	 * @param lst price list
	 */
	void setPriceList(List<Price> lst);

}
