package com.bridgelabz.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.bridgelabz.dao.RegistrationDao;
import com.bridgelabz.filters.RegistrationFormValidate;
import com.bridgelabz.model.AttributesFile;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected AttributesFile attributesFile;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String statusMessage=null;
		HttpSession session=request.getSession();
		session.setAttribute("error-flag", "0");
		String userName=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		long mobileNumber=Long.parseLong(request.getParameter("mobileNumber")==""? "0" : request.getParameter("mobileNumber"));
		
		session.setAttribute("error-flag", "0");
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!RegistrationFormValidate.validateUserName(userName,session)) {
				session.setAttribute("error-flag", "1");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "2");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validatePassword(password,session)) {
				session.setAttribute("error-flag", "3");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validateMobileNumber(mobileNumber,session)) {
				session.setAttribute("error-flag", "4");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else {
				session.removeAttribute("error-flag");
				try {
					statusMessage="false";
					RegistrationDao.register(userName, emailId, password, mobileNumber);
					response.sendRedirect("/Login/JSP/index");
				}catch(PersistenceException e) {
					Map<String,String> toJson=new HashMap<String,String>();
					statusMessage="true";
					toJson.put("isFailed",statusMessage);
					JSONObject json=new JSONObject(toJson);
					response.setContentType("application/json");
					response.getWriter().print(json);
				}
			}
		}
	}
}
