package com.app.service;

import java.util.List;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.repository.UserRepositoryImpl;

public class UserService {

	private UserRepository userRepo;
	
	public UserService() {
		this.userRepo = new UserRepositoryImpl();
	}
	
	public List<User> findAll(){
		return this.userRepo.findAll();
	}
	
	public boolean isValidUser(String username, String password) {
		List<User> users = this.findAll();
		
		for(User u: users) {
			if(u.getName().equals(username) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
