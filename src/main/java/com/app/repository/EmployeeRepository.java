package com.app.repository;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Manager;

public interface EmployeeRepository {

	Employee viewEmployeeInfo(int userid) throws BusinessException;
	Employee getEmployee(int userid);
	void update(Employee employee);
	Manager getManager(int id);
	List<Employee> viewEmployees(int managerid)throws BusinessException;
}
