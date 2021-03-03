package com.app.repository;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeRepository {

	Employee viewEmployeeInfo(int userid) throws BusinessException;
	Employee getEmployee(int userid);
}
