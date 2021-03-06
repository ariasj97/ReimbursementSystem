package com.app.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.exception.BusinessException;
import com.app.model.Employee;
import com.app.model.Login;
import com.app.repository.LoginRepository;
import com.app.util.HibernateSessionFactory;

public class LoginRepoImpl implements LoginRepository {

	@Override
	public int login(String email, String password) throws BusinessException {
		
		Session s = null;
		Transaction tx = null;
		int id = 0;
		int tid = 0;
		
		String temail = "";
		String tpassword = "";
		
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			Login login = (Login) s.createQuery("FROM Login L WHERE L.email = :email").setParameter("email", email).uniqueResult();
			
			if (login.getUserId()!=null) {
				id = login.getUserId().getUserId();
			}else {
				id = login.getManagerId().getManagerId();
			}
			
			temail = login.getEmail();
			tpassword = login.getPassword();
				
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}catch(NullPointerException e) {
			tid = 0;
		}finally {
			s.close();
		}
		
		/*if combination of email and password exist then it returns the id of 
		 * employee or id else it returns 0 
		 */
		
		if(temail.equals(email) && tpassword.equals(password)) {
			tid = id;
		}else {
			tid = 0;
		}
		System.out.println(tid);
		return tid;
	}

	@Override
	public int getId(String email) throws BusinessException {
		int id = 0;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			Login login = (Login) s.createQuery("FROM Login L WHERE L.email = :email").setParameter("email", email).uniqueResult();
			
			if (login.getUserId()!=null) {
				id = login.getUserId().getUserId();
			}else {
				id = login.getManagerId().getManagerId();
			}}catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			}finally {
				s.close();
			}
		
		
		
		return id;
		}

}
