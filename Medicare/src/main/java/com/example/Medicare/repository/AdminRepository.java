package com.example.Medicare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Medicare.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {


	boolean existsByEmail(String email);

	Admin findByEmail(String email);

	Admin findByEmailAndPassword(String email, String password);
}
