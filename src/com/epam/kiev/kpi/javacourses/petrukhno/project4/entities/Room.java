package com.epam.kiev.kpi.javacourses.petrukhno.project4.entities;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.PriceDao;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which represents room in hotel
 * 
 */

public class Room {
    
	private int id;
	private RoomClass roomClass;
	private int beds;
	private int number;
		
	/**
	 * 
	 * @return id of room
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * 
	 * @param id of room
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * 
	 * @return class of hotel room
	 */
	public RoomClass getRoomClass() {
		return roomClass;
	}
	
	
	/**
	 * 
	 * @param roomClass class of hotel room
	 */
	public void setRoomClass(RoomClass roomClass) {
		this.roomClass = roomClass;
	}
	
	
	/**
	 * 
	 * @return number of hotel room
	 */
	public int getNumber() {
		return number;
	}
	
	
	/**
	 * 
	 * @param number number of hotel room
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	/**
	 * 
	 * @return count of beds in hotel room
	 */
    public int getBeds() {
		return beds;
	}
    
    
    /**
     * 
     * @param bads count of beds in hotel room
     */
	public void setBeds(int bads) {
		this.beds = bads;
	}
	
	
	/**
	 * Recieve price from database
	 * @return price of room multiplied on 100
	 */
	public int getPrice(){
		DaoFactory daoFactory = DaoFactory.getInstance();
		PriceDao priceDao = daoFactory.createPriceDao();
		return priceDao.getPrice(getRoomClass(), getBeds());
	}
	
	
}
