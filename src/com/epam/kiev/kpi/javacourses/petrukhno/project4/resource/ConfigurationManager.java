package com.epam.kiev.kpi.javacourses.petrukhno.project4.resource;

import java.util.ResourceBundle;


/**
 * 
 * @author Yaroslav Petrukhno
 * 
 * Implements methods to read values of config file
 *
 */

public class ConfigurationManager {
    
	private final static ResourceBundle resourceBundle = 
    		ResourceBundle.getBundle("com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.config");
    
    private ConfigurationManager() { }
    
    public static String getProperty(String key){
        return resourceBundle.getString(key);	
    }
}
