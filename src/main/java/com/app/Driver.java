package com.app;

import com.app.util.HibernateSessionFactory;

public class Driver {

	public static void main(String ...arStrings) {
		
		HibernateSessionFactory.getSession();
	}
}
