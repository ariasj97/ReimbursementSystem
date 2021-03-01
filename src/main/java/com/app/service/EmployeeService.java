package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import com.app.repository.impl.EmployeeRepoImpl;

public class EmployeeService {

	private EmployeeRepository employeeRepo;
	
	public EmployeeService() {
		this.employeeRepo = new EmployeeRepoImpl();
	}
	
	public Employee viewEmployeeInfo(int userId) throws BusinessException{
		Employee employee = new Employee();
		
		try {
			employee = employeeRepo.viewEmployeeInfo(userId);
		}catch(BusinessException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
