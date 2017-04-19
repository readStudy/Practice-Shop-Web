package com.practice.user.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.practice.user.enums.UserState;
import com.practice.user.model.User;
import com.practice.user.repository.UserRepository;
import com.practice.user.service.UserService;
import com.practice.utils.MailUtils;
import com.practice.utils.UUIDUtils;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository repository;

	@Override
	public void add(User u) {

		// 用戶一開始尚未啟用
		u.setState(UserState.INACTIVE.value());
		// 給用戶一個啟用碼
		u.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
		repository.save(u);
		MailUtils.sendMail(u.getEmail(), "測試啟用信件", "<h1>XXX購物商城啟用!點下面鏈結完成啟用!</h1>"
				+ "<h3> <a href='http://127.0.0.1:8080/user/register/"+ u.getUsername() +"/active/" + u.getCode() + "'>啟用</a></h3>");
	}

	@Override
	public void update(User u) {
		repository.save(u);
	}

	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public User findByCode(String code) {
		return repository.findByCode(code);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public void save(User user) {
		repository.save(user);

	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}
}
