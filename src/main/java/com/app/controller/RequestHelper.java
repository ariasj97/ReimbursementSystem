package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.service.UserService;



public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		final String URI = request.getRequestURI();
		System.out.println(URI);
		
		final String RESOURCE = URI.replace("/ReimbursementSystem/api", "");
		System.out.println(RESOURCE);
		
		switch(RESOURCE) {
		case "/user/all":
			response.setStatus(200);
			return new UserService().findAll();
			
		default:
			response.setStatus(404);
			return "Sorry the resource you have requested is not available or does not exist";
		}
	}

	public static void processPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		final String URI = request.getRequestURI();
		final String RESOURCE =URI.replace("/ReimbursementSystem/api", "");
		
		
		switch(RESOURCE) {
		case "/login":
			final String EMAIL = request.getParameter("useremail");
			final String PASS = request.getParameter("userpass");
			
			System.out.println(EMAIL);
			System.out.println(PASS);
			
			if (new UserService().isValidUser(EMAIL, PASS)) {
				//if the user credential are valid, I'll grab them a session and redirect the client to a new resource
				
				//response.sendRedirect("/ServletReview/Pages/home.html");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Pages/home.html");
				dispatcher.forward(request, response);
				
				//granting a session to client
				HttpSession session = request.getSession();
				session.setAttribute("useremail", EMAIL);
			}
			break;
		default:
			response.setStatus(404);
		
	}
	}
	
}