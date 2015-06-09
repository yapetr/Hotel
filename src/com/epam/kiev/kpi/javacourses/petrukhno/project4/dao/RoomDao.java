package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao;

import java.util.List;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Room;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * 
 * Interface to access data of rooms
 * 
 */
public interface RoomDao {
	/**
	 * Creates a room in database based on data of object of Room class
	 * @param room
	 */
	void create(Room room);
	
	/**
	 * Deletes a room with defined id 
	 * @param id - id of room to be deleted
	 */
	void delete(int id);
	
	/**
	 * Returnes list of rooms that most sutable to passing order
	 * Rooms in list sorted from more sutable for this orders rooms
	 * to less sutable 
	 * 
	 * @param order - passing order
	 * @return list of sutable rooms
	 */
	List<Room> findFree(Order order);
	
	/**
	 * Returnes list of all rooms in hotel
	 * 
	 * @return list of rooms
	 */
	List<Room> findAll();
}
