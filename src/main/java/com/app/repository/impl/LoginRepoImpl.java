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
		int managerid = 0;
		int userid = 0;
		
		String temail = "";
		String tpassword = "";
		
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			Login login = (Login) s.createQuery("FROM Login L WHERE L.email = :email").setParameter("email", email).uniqueResult();
			
			if (login.getUserId()!=null) {
				userid = login.getUserId().getUserId();
			}else {
				managerid = login.getManagerId().getManagerId();
			}
			
			temail = login.getEmail();
			tpassword = login.getPassword();
				
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		if(temail.equals(email) && tpassword.equals(password)) {
			return id;
		}
		
		
	}

}
