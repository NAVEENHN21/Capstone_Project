package com.example.Medicare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Medicare.entity.Cart;
import com.example.Medicare.entity.User;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

	List<Cart> findAllById(int id);

	List<Cart> findByUser(User user);
	
}
