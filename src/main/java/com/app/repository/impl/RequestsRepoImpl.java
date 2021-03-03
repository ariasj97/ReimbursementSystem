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
			
//			String hql = "FROM requests r WHERE r.userid = :userid";
//			Query query = s.createQuery(hql);
//			query.setParameter("userid",userId);
//			request = query.list();
			
			request =s.createQuery("FROM Requests WHERE userid = :userid", Requests.class).setParameter("userid", userId).getResultList();
//			System.out.println("before");
//			request.forEach(System.out::println);
//			System.out.println("after");
			
//			for(Requests myRequest : request) {
//				Date date = myRequest.getDate();
//				myRequest.setDate(Date.valueOf(sdf.format(date)));
//				System.out.println(myRequest.getDate());
//			}
			
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

	
}
