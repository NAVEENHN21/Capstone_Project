package com.example.Medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Medicare.entity.Cart;
import com.example.Medicare.entity.Medicine;
import com.example.Medicare.entity.User;
import com.example.Medicare.repository.CartRepository;



public interface CartService {

	Cart add(User user, Medicine medicine);
	
	List<Cart> getCartItems(User user);
	
	String deleteCartItem(int id);



}
