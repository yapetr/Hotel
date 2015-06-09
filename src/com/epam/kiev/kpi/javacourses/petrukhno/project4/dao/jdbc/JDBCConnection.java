package com.epam.kiev.kpi.javacourses.petrukhno.project4.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Takes connection from connection pool 
 *
 */


public class JDBCConnection {
	
	/**
	 * Returnes connection from connection pool of GlassFish
	 * 
	 * @return JDBC connection
	 */

	public static Connection getConnection() {

		DataSource ds;
		InitialContext context;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("jdbc/HotelDB");
			return ds.getConnection();

		} catch (NamingException | SQLException e) {

            Logger logger = LogManager.getLogger(JDBCConnection.class.getName());
        	logger.error("Error taking connection from connection pool " + e );
		}
		return null;
	}
}


