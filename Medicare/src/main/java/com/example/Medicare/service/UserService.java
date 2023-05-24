package com.example.Medicare.service;

import javax.transaction.Transactional;

import com.example.Medicare.entity.User;
import com.example.Medicare.exception.DuplicateEmailException;

public interface UserService {
	
	@Transactional
	
	User create(User user) throws DuplicateEmailException;
	
	User login(String email, String password);

	User authenticateUser(String username, String password);

	
	
	
}
