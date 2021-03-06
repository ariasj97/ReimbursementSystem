package com.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Manager;
import com.app.model.Requests;
import com.app.service.EmployeeService;
import com.app.service.LoginService;
import com.app.service.RequestsService;




public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		final String URI = request.getRequestURI();
		System.out.println(URI);
		
		final String RESOURCE = URI.replace("/ReimbursementSystem/api", "");
		System.out.println(RESOURCE);
		
		switch(RESOURCE) {
		case "/ViewAllRequests":
			List<Requests> allRequests = new ArrayList<>();
			try {
				
				allRequests = new RequestsService().viewRequests();
				
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			return allRequests;
			
		case "/ViewEmployees":
			List<Employee> employees = new ArrayList<>();
			try {
				Integer idAttribute = (Integer) request.getSession().getAttribute("id");
				employees = new EmployeeService().viewEmployees(idAttribute);
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			return employees;
		case "/PendingRequests":
			
			List<Requests> requests = new ArrayList<>();
			try {
				
				Integer idAttribute = (Integer) request.getSession().getAttribute("id");
				requests = new RequestsService().viewRequests(idAttribute);
				//response.sendRedirect("/ReimbursementSystem/Pages/pendingrequests.html");
				
			}catch(BusinessException e) {
				e.printStackTrace();
			}
			System.out.println(requests +"RH");
			return requests;
					
		case "/ViewInformation":
			
			Employee employee  = new Employee();
			try {
				//response.sendRedirect("/ReimbursementSystem/Pages/viewinformation.html");
				//System.out.println("get1");
				Integer idAttribute = (Integer) request.getSession().getAttribute("id");
				employee = new EmployeeService().viewEmployeeInfo(idAttribute);
				//System.out.println(employee);
				//System.out.println("GET2");
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
		RequestsService requestsService = new RequestsService();
		EmployeeService employeeService = new EmployeeService();
		
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
	
			final Double AMOUNT = Double.parseDouble(request.getParameter("amount"));
			final Date DATE = new Date(System.currentTimeMillis());
			final boolean status =false;
			System.out.println(AMOUNT);
			System.out.println(DATE);
			Integer idAttribute = (Integer) request.getSession().getAttribute("id");
			Employee employee = new EmployeeService().getEmployee(idAttribute);
			
			Requests newRequests = new Requests(2,employee,status,AMOUNT ,DATE);
			
			System.out.println(newRequests);
			requestsService.insert(newRequests);
			response.sendRedirect("http://localhost:8080/ReimbursementSystem/Pages/reimbursementrequest.html");
				
			break;
			
		case "/UpdateInformation":
			final String FNAME = request.getParameter("fname");
			final String LNAME = request.getParameter("lname");
			final int NUM = Integer.parseInt(request.getParameter("phonenumber"));
			final String ADDRESS = request.getParameter("streetaddress");
			
			Integer idAttribute2 = (Integer) request.getSession().getAttribute("id");
			Employee test =  new EmployeeService().getEmployee(idAttribute2);
			
			Manager manager = test.getManagerId();
			Employee emp = new Employee(idAttribute2,FNAME,LNAME,ADDRESS,NUM,manager);
			
			employeeService.update(emp);
			response.sendRedirect("http://localhost:8080/ReimbursementSystem/Pages/updateinformation.html");
			break;
		case "/AcceptRequests":
			final int REQUESTID =Integer.parseInt(request.getParameter("requestId"));
			requestsService.acceptRequests(REQUESTID);
			response.sendRedirect("http://localhost:8080/ReimbursementSystem/Pages/acceptrequests.html");
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