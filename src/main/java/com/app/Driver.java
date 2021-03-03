package com.app;

import java.sql.Date;

import com.app.model.Employee;
import com.app.model.Requests;
import com.app.repository.impl.EmployeeRepoImpl;
import com.app.repository.impl.RequestsRepoImpl;
import com.app.util.HibernateSessionFactory;

public class Driver {

	public static void main(String ...arStrings) {
		
		HibernateSessionFactory.getSession();
		EmployeeRepoImpl employeeRepo = new EmployeeRepoImpl();
		RequestsRepoImpl requestRepo = new RequestsRepoImpl();
		
		Employee employee =  employeeRepo.getEmployee(1);
		Requests request = new Requests(employee,false,250.00,new Date(332021));
		requestRepo.insert(request);
		
	}
}
