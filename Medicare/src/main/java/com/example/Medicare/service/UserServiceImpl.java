package com.example.Medicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Medicare.entity.User;
import com.example.Medicare.exception.DuplicateEmailException;
import com.example.Medicare.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User create(User user) throws DuplicateEmailException {

		User users = userRepository.findByEmail(user.getEmail());
		
		System.out.println("this is list of users " +users);

		if (users!=null) {
			throw new DuplicateEmailException(user.getEmail());
		} else {
			userRepository.save(user);
			return user;
		}

	}

	@Override
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public User authenticateUser(String username, String password) {
	    // TODO: Implement your actual authentication logic here
	    
	    // Hardcoded example credentials for demonstration purposes
	    if (username.equals("admin") && password.equals("password")) {
	        User user = new User();
	        user.setName(username);
	        // Set other user properties as needed
	        return user;
	    }
	    
	    return null; // Return null if authentication fails
	}

}
