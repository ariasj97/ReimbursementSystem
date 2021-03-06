package com.app.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.app.exception.BusinessException;
import com.app.model.Requests;
import com.app.repository.RequestsRepository;
import com.app.util.HibernateSessionFactory;

public class RequestsRepoImpl implements RequestsRepository{

	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	
	@Override
	public List<Requests> viewRequests(int userId) throws BusinessException {

		Session s = null;
		Transaction tx = null;
		
		List<Requests> request = new ArrayList<>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			request =s.createQuery("FROM Requests WHERE userid = :userid", Requests.class).setParameter("userid", userId).getResultList();

			
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return request;
	}

	@Override
	public void insert(Requests request) {
	
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			
			s.save(request);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}

		
	}

	@Override
	public List<Requests> viewAllRequests() throws BusinessException {
		Session s = null;
		Transaction tx = null;
		boolean status = false;
		List<Requests> request = new ArrayList<>();

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			request =s.createQuery("FROM Requests WHERE status = :status", Requests.class).setParameter("status", status).getResultList();

			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return request;
	}

	@Override
	public void acceptRequest(int requestid) {
		Session s = null;
		Transaction tx = null;
		System.out.println(requestid);
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();

			s.createQuery("UPDATE Requests r SET r.status = true WHERE r.requestid = :requestid").setParameter("requestid", requestid).executeUpdate();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}
	

}
