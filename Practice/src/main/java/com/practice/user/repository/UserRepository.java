package com.practice.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.practice.user.model.User;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	User findByCode(String code);
}