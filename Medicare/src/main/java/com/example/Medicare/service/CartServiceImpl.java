package com.example.Medicare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Medicare.entity.Cart;
import com.example.Medicare.entity.Medicine;
import com.example.Medicare.entity.User;
import com.example.Medicare.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	

	
	@Override
	public Cart add(User user, Medicine medicine) {
		Cart cart = new Cart();
		cart.setMedicine(medicine);
		cart.setUser(user);
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public List<Cart> getCartItems(User user) {
		List<Cart> cartItems=(List<Cart>) cartRepository.findByUser(user);
		if(cartItems.size()>0) {
			return cartItems;
		}
		
		return null;
	}

	@Override
	public String deleteCartItem(int id) {
		if(cartRepository.existsById(id)) {
			cartRepository.deleteById(id);
			return "deleted";
		}
		return "id not found";
	}







}
