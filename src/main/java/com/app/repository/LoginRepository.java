package com.app.repository;

import com.app.exception.BusinessException;

public interface LoginRepository {
	
	 int login(String email, String password) throws BusinessException;
		
}
