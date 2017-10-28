package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.LoginDao;
import com.bridgelabz.filters.LoginValidate;
/**
 * Purpose: Capture the input parameter from the index.jsp file and validate it against the LoginDao
 * @author Dipendra Rana
 * @since 6 Oct 2017
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false); //returns session object if exists else returns null. Note the significance of boolean value 
		// Get the printwriter object from response to write the required json object to the output stream
		session.setAttribute("error-flag", "0");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!LoginValidate.validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "1");
				response.sendRedirect("/Login/JSP/index");
			}
			else if(!LoginValidate.validatePassword(password,session)) {
				session.setAttribute("error-flag", "2");
				response.sendRedirect("/Login/JSP/index");
			}
			else {
				session.removeAttribute("error-flag");
				System.out.println("inside login");
				String userName=LoginDao.validate(emailId, password);
				if(session!=null)
					session.setAttribute("name", userName);
				if(userName!=null) 
					response.sendRedirect("/Login/JSP/welcome");
				else
					response.sendRedirect("/Login/JSP/index");
			}
		}
	}

}
