package com.example.Medicare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Medicare.entity.Admin;
import com.example.Medicare.exception.DataNotFoundException;
import com.example.Medicare.exception.DuplicateEmailException;
import com.example.Medicare.repository.AdminRepository;

@Service
public class AdminServiceImpal implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public int create(Admin admin) throws DuplicateEmailException {
		if (adminRepository.existsByEmail(admin.getEmail())) {
			throw new DuplicateEmailException(admin.getEmail());
		} else {
			int id = adminRepository.save(admin).getId();
			return id;
		}
	}

	@Override
	public Admin find(String email) throws DuplicateEmailException {
		Optional<Admin> admin = adminRepository.findById(1);
		
		Admin ad = admin.get();
		
		if(adminRepository.existsByEmail(email)) {
			
			return ad;
		}
		else {
			return null;
		}
	}


	@Override
	public Object find(String email, String password) throws DataNotFoundException {
		System.out.println(email + " " + password);
		Admin admin = adminRepository.findByEmailAndPassword(email, password);
		if (admin == null) {
			throw new DataNotFoundException();
		}
		return admin;
		
	}
	
	
	@Override
	public void changePassword(int id, String oldPassword, String newPassword) throws Exception {
		Optional<Admin> admin = adminRepository.findById(id);
		Admin ad = admin.get();
		if (oldPassword.equals(ad.getPassword())) {
			ad.setPassword(newPassword);
			adminRepository.save(ad);
		} else {
			throw new Exception("Invalid Password");
		}
		
	}

	@Override
	public Admin findByEmail(String email) throws DuplicateEmailException {
		
		return null;
	}

	
}
