package com.bridgelabz.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CookiesHandler
 */
public class CookiesHandler implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpSession session=httpRequest.getSession();
		if(session.getAttribute("name")==null) {
			httpResponse.sendRedirect("/Login/JSP/index");
		}
		else {
			httpResponse.setHeader("Pragma","no-cache");	//provides backward compatibility for HTTP 1.0
			httpResponse.setHeader("Cache-Control","no-store,no-cache,must-revalidate,private");	// provided in HTTP 1.1
			httpResponse.setDateHeader("Expires", 0);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
