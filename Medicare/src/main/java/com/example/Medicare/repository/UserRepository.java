package com.example.Medicare.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.Medicare.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);

}
