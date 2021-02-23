package com.app.repository;

import java.util.Arrays;
import java.util.List;

import com.app.model.User;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<User> findAll() {
		return Arrays.asList(
				new User(1, "johndoe@gmail.com", "password"),
				new User(2, "admin@yahoo.com", "admin"),
				new User(3, "calligraphist@revature.com", "yolo"),
				new User(4, "soulcaliber@gmail.com", "pass"),
				new User(5, "luffy@jumpforce.com", "awspass")
				);
	}
}
