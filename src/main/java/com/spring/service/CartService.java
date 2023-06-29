package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entitys.Cart;

@Service
public interface CartService {

	public Cart add(Cart cart);
	public Cart update(Cart cart);
	public void delete(Cart cart);
	public List<Cart> getCartbyUser(String username);
	public Cart getById(String username , Integer id, String kt);
	public void deleteCartByUsername(String username);
	
}
