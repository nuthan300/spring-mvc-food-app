package com.ty.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;

@Component
public class UserService {

	@Autowired
	UserDao dao;

	public boolean saveUser(User user) {
		return dao.saveUser(user);
	}

	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	public boolean deleteUserbyId(int id) {
		return dao.deleteUserbyId(id);
	}

	public User validateUser(String email, String password) {
		return dao.validateUser(email, password);
	}

	public List<User> getAllUser() {
		return dao.getAllUser();
	}
}
