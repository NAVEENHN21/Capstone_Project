package com.example.Medicare.service;

import javax.transaction.Transactional;

import com.example.Medicare.entity.Admin;
import com.example.Medicare.exception.DataNotFoundException;
import com.example.Medicare.exception.DuplicateEmailException;



public interface AdminService {
	@Transactional
	int create(Admin admin) throws DuplicateEmailException;

	Admin findByEmail(String email) throws DuplicateEmailException;

	Object find(String email, String password) throws DataNotFoundException;

	Admin find(String email) throws DuplicateEmailException;

	void changePassword(int id, String oldPassword, String newPassword) throws Exception;
}