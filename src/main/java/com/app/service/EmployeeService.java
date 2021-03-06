package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Manager;
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
	
	
	public Employee getEmployee(int userid){
		Employee employee = new Employee();
		
		employee = employeeRepo.getEmployee(userid);
		
		return employee;
	}
	public void update(Employee employee) {
		this.employeeRepo.update(employee);
	}
	
	public Manager getManager(int id) {
		 Manager manager = new Manager();
		 manager = employeeRepo.getManager(id);
		 return manager;
	 }
	
	public List<Employee> viewEmployees(int managerid)throws BusinessException{
		return this.employeeRepo.viewEmployees(managerid);
	}
}
