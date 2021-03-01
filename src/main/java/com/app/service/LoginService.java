package com.app.service;

import com.app.repository.LoginRepository;
import com.app.repository.impl.LoginRepoImpl;

import java.io.IOException;

import com.app.exception.BusinessException;

public class LoginService {

	private LoginRepository loginRepo;
	
	public LoginService() {
		this.loginRepo = new LoginRepoImpl();
	}
	
	public String login(String email, String password) throws BusinessException {
		
		String url = "";
		
		try {
			if(loginRepo.login(email, password)<100 && loginRepo.login(email, password) >0) {
				url = "/Pages/home.html";
			}else if(loginRepo.login(email, password)>99) {
				url = "/Pages/managerhome.html";
			}else if (loginRepo.login(email, password)==0 ) {
				url = "/Pages/wronglogin.html";
			}
		}catch(BusinessException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	public int getId(String email) throws BusinessException{
		int id = 0;
		try {
			id = loginRepo.getId(email);
		}catch(BusinessException e) {
			e.printStackTrace();
		}
		
		
		return id;
	}
}
