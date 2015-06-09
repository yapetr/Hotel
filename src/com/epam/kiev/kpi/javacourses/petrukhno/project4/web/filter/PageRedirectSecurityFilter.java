package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.ConfigurationManager;

/**
 * 
 * @author Yarolav Petrukhno
 *
 * Security filter which avoids dire access to pages in 
 * jsp folder
 */

@WebFilter(urlPatterns={"/jsp/*"})
public class PageRedirectSecurityFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect(httpRequest.getContextPath() + ConfigurationManager.getProperty("path.page.index"));
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {

	}


}
