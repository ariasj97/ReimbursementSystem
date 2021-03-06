package com.app.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Login;
import com.app.model.Manager;
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

	@Override
	public Manager getManager(int id) {
		Session s = null;
		Transaction tx = null;
		Manager manager = new Manager();
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			manager = s.get(Manager.class, id);
			System.out.println(manager+"impl");
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return manager;
	}

	@Override
	public List<Employee> viewEmployees(int managerid)throws BusinessException {
		Session s = null;
		Transaction tx = null;
		List <Employee> employees = new ArrayList<>();
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			employees = s.createQuery("FROM Employee WHERE managerid =:managerid", Employee.class).setParameter("managerid", managerid).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		
		return employees;
	}
	}

	
