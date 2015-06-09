package com.epam.kiev.kpi.javacourses.petrukhno.project4.entities;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Bean which represents class of room in hotel
 *  
 */


public class RoomClass {
	
	int id;
	String name;
	
	/**
	 * 
	 * @return id of room class
	 */
	public int getId() {
		return id;
	}

	
	/**
	 * 
	 * @param id of room class
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * 
	 * @return name of room class
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * 
	 * @param name name of room class
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * String representing of room class
	 */
	@Override
	public String toString() {
		return getName();
	}	

	
}
