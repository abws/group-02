package com.spicesrus.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.spicesrus.model.Cart;
import com.spicesrus.repository.CartRepository;

@Component
public class CartHelper {
	private static CartRepository cRepo;
	
	public CartHelper(CartRepository cRepo) {
		CartHelper.cRepo = cRepo;
	}
	public static Cart createOrRetrieveCart(Model model, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = cRepo.save(new Cart());
			request.setAttribute("cart", cart);
		}
		else {
			cart = cRepo.findById(cart.getId()).get();
		}
		model.addAttribute("cart", cart);
		return cart;	
	}
}
