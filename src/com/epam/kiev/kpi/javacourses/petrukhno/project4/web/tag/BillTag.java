package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.tag;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.entities.Order;

/**
 * 
 * @author Yarolav Petrukhno
 * 
 * Based on processed by administrator order
 * tag displays bill to user
 *   
 */


@SuppressWarnings("serial")
public class BillTag extends TagSupport {

	private Order order;
	
	
	
	public void setOrder(Order order) {
		this.order = order;
	}



	@Override
	public int doStartTag() throws JspException {
		
		Locale locale = (Locale) Config.get(pageContext.getSession(), Config.FMT_LOCALE);		
		ResourceBundle resourses = null;
		if(locale == null){
			resourses = ResourceBundle.getBundle("com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.Resourses");
		} else {	
			resourses = ResourceBundle.getBundle("com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.Resourses", locale);
		}

		try {
			
			double price = (double) order.getRoom().getPrice()/ 100;			
			JspWriter out = pageContext.getOut();
			out.write("<table border=1>");			
			out.write("<caption>"+ resourses.getObject("billtag.label.bill") +" ¹" + order.getId() + "</caption>");
			out.write("<tr><th>" + resourses.getObject("billtag.label.order")  + " </th>"
					+ "<th>" + resourses.getObject("billtag.label.days")   + "</th>"
					+ "<th>" + resourses.getObject("billtag.label.price")  + "</th>"
					+ "<th>" + resourses.getObject("billtag.label.sum")  + "</th></tr>");
			out.write("<tr><td>" 
			    + order + "</th><td>" 
			    + order.getDays()+ "</td><td>" 
				+ price + "</td><td>" 
			    + price * order.getDays()
				+ "</td></tr>");
			out.write("</table>");	
		} catch (IOException e) {
	    	Logger logger = LogManager.getLogger(BillTag.class.getName());
        	logger.error("Error creating Bill tag " + e);	
		}
		
		return SKIP_BODY;
	}

}
