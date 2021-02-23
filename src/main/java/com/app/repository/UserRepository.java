package com.app.repository;

import java.util.List;

import com.app.model.User;



public interface UserRepository {

	List<User> findAll();
}
