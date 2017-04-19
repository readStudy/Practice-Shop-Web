package com.practice.user.service;

import com.practice.user.model.User;

public interface UserService {
	void add(User u);
	void update(User u);
	Iterable<User> findAll();
	User findById(Long id);
	void delete(Long id);
	User findByCode(String code);
	User login(String username, String password);
	User findByUsername(String username);
	void save(User editUser);
	void delete(User user);
}
