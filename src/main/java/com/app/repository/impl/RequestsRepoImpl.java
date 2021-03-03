package com.app.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.exception.BusinessException;
import com.app.model.Requests;
import com.app.repository.RequestsRepository;
import com.app.util.HibernateSessionFactory;

public class RequestsRepoImpl implements RequestsRepository{

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
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return request;
	}

}
