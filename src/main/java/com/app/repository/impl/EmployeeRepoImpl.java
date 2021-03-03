package com.app.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Login;
import com.app.repository.EmployeeRepository;
import com.app.util.HibernateSessionFactory;

public class EmployeeRepoImpl implements EmployeeRepository {

	@Override
	public Employee viewEmployeeInfo(int userId) throws BusinessException {
		
		Session s = null;
		Transaction tx = null;
		Employee employee = new Employee();
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			employee = s.get(Employee.class, userId);
			System.out.println(employee);
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		
		return employee;
}

	@Override
	public Employee getEmployee(int userid) {
		Session s = null;
		Transaction tx = null;
		Employee employee = new Employee();
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			employee = s.get(Employee.class, userid);
			System.out.println(employee);
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return employee;
	}

	@Override
	public void update(Employee employee) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.update(employee);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}

		
	}
	}

	
