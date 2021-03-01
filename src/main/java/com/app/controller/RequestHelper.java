package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import com.app.service.LoginService;




public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		final String URI = request.getRequestURI();
		System.out.println(URI);
		
		final String RESOURCE = URI.replace("/ReimbursementSystem/api", "");
		System.out.println(RESOURCE);
		
		switch(RESOURCE) {
//		case "/PendingRequests":
//			response.sendRedirect("/ReimbursementSystem/Pages/pendingrequests.html");
//			break;
		case "/ViewInformation":
			Employee employee  = new Employee();
			try {
				Integer idAttribute = (Integer) request.getSession().getAttribute("id");
				employee = new EmployeeService().viewEmployeeInfo(idAttribute);
				System.out.println(employee);
				//response.sendRedirect("/ReimbursementSystem/Pages/viewinformation.html");
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			return employee;
		case "/logout":
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
				
			}
			return "Your session has been invalidated.";
		default:
			response.setStatus(404);
			return "Sorry the resource you have requested is not available or does not exist";
		}
	}

	public static void processPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		final String URI = request.getRequestURI();
		final String RESOURCE =URI.replace("/ReimbursementSystem/api", "");
		int id = 0;
		
		switch(RESOURCE) {
		case "/login":
			final String EMAIL = request.getParameter("useremail");
			final String PASS = request.getParameter("userpass");
			
			System.out.println(EMAIL);
			System.out.println(PASS);
			
			try {
				String newlogin = new LoginService().login(EMAIL,PASS);
				HttpSession session = request.getSession();
				id = new LoginService().getId(EMAIL);
				session.setAttribute("id", id);
				RequestDispatcher dispatcher = request.getRequestDispatcher(newlogin);
				dispatcher.forward(request, response);
				
				
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			
			break;
		case "/ReimbursementRequest":
			response.sendRedirect("/ReimbursementSystem/Pages/reimbursementrequest.html");
			break;
		case "/PendingRequests":
			response.sendRedirect("/ReimbursementSystem/Pages/pendingrequests.html");
			break;
		case "/ViewInformation":
			try {
				Integer idAttribute = (Integer) request.getSession().getAttribute("id");
				new EmployeeService().viewEmployeeInfo(idAttribute);
				response.sendRedirect("/ReimbursementSystem/Pages/viewinformation.html");
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			
			break;
		case "/UpdateInformation":
			response.sendRedirect("/ReimbursementSystem/Pages/updateinformation.html");
			break;
		case "/logout":
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Pages/home.html");
				dispatcher.forward(request, response);
				System.out.println("logged out");
			}
		default:
			response.setStatus(404);
		
	}
	}
	
}