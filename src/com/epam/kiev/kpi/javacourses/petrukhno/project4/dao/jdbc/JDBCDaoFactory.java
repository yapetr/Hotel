package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.jdbc;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.DaoFactory;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.OrderDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.PriceDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomClassDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.RoomDao;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.UserDao;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Realizes DAO Factory for JDBC connection
 *
 */

public class JDBCDaoFactory extends DaoFactory {

	@Override
	public OrderDao createOrderDao() {

		return new JDBCOrderDao();
	}


	@Override
	public RoomClassDao createRoomClassDao() {

		return new JDBCRoomClassDao();
	}
	
	
	@Override
	public RoomDao createRoomDao() {

		return new JDBCRoomDao();
	}

	
	@Override
	public UserDao createUserDao() {

		return new JDBCUserDao();
	}


	@Override
	public PriceDao createPriceDao() {

		return new JDBCPrice();
	}

}
