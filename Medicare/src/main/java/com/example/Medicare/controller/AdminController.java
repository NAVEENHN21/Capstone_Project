package com.example.Medicare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicare.entity.Admin;
import com.example.Medicare.exception.DuplicateEmailException;
import com.example.Medicare.service.AdminService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("adminLogin")
	public Admin adminCredentials(@RequestBody Admin ad, HttpServletRequest request) throws DuplicateEmailException {

		String name = "Sporty Shoes";
		String email = "simplilearn@gmail.com";
		String password = "admin";
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		try {
			adminService.create(admin);
		} catch (DuplicateEmailException e) {
			e.getMessage();
		}

		Admin adminget = adminService.find("simplilearn@gmail.com");
		System.out.println(adminget);

		if ((adminget.getEmail()).equals(ad.getEmail()) && (adminget.getPassword()).equals(ad.getPassword())) {
			HttpSession usersession = request.getSession();
			usersession.setAttribute("LoginCredentials", adminget);
			return adminget;
		} else {
			return null;
		}

	}

	@PutMapping("/changePassword")
	public Admin changePassword(@RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Admin admin = (Admin) session.getAttribute("LoginCredentials");
		try {
			admin = adminService.find(admin.getEmail());
		} catch (DuplicateEmailException e1) {
			e1.printStackTrace();
		}

		try {
			adminService.changePassword(1, password, newPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}
}
