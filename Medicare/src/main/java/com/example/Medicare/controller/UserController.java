package com.example.Medicare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicare.entity.User;
import com.example.Medicare.exception.DuplicateEmailException;
import com.example.Medicare.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public User createUser(@RequestBody User user) {
		User newUser = null;
		try {
			newUser = userService.create(user);
		} catch (DuplicateEmailException e) {
			e.printStackTrace();
		}
		return newUser;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.login(email, password);
		return user;
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
//	    // Assuming you have a userService that performs user authentication
//	    User user = userService.authenticateUser(email, password);
//
//	    if (user != null) {
//	        // Set the user's login credentials in the session
//	        HttpSession session = request.getSession();
//	        session.setAttribute("LoginCredentials", user);
//
//	        return ResponseEntity.ok("Login successful");
//	    } else {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//	    }
//	}


}

