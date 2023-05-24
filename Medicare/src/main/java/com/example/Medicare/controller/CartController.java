package com.example.Medicare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicare.entity.Cart;
import com.example.Medicare.entity.Medicine;
import com.example.Medicare.entity.User;
import com.example.Medicare.service.CartService;
import com.example.Medicare.service.MedicineService;
import com.example.Medicare.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	MedicineService medicineService;
	
	
	@PostMapping("/addCart/{id}")
	public Cart addItem(@PathVariable int id,HttpServletRequest request) {
		HttpSession session= request.getSession();
		User user = (User) session.getAttribute("LoginCredentials");
		
		Medicine medicine = medicineService.getMedicine(id);
		
		Cart cart = cartService.add(user, medicine);
		return cart;
		
	}


	
	@GetMapping("/getCart")
	public List<Cart> getCartItems(HttpServletRequest request){
		HttpSession session= request.getSession();
		User user = (User) session.getAttribute("LoginCredentials");
	
		List<Cart> cartItems = cartService.getCartItems(user);
		
		return cartItems;
	}
	


	@DeleteMapping("/deleteCart/{id}")
	public String deleteCartItem(@PathVariable int id) {
		String str = cartService.deleteCartItem(id);
		return str;
	}
}
