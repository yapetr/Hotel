package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.RoomClass;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * 
 * Interface to access data of room classes
 * 
 */
public interface RoomClassDao {
	/**
	 * Creates new room class in database based on data of object of RoomClass
	 * class
	 * 
	 * @param roomClass 
	 */
    void create(RoomClass roomClass);
    
    /**
     * Returnes list of all RoomClasses that present in database
     * 
     * @return all roomclasses
     */
    List<RoomClass> findAll(); 
    
    /**
     * Deletes room class with defined id
     * 
     * @param id - id of room class to delete
     */
    void delete(int id);
}
