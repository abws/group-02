package com.spicesrus.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.spicesrus.model.Cart;
import com.spicesrus.repository.CartRepository;

/**
 * Central class to create, retrieve and add cart objects to model
 * @author Abdiwahab
 *
 */
@Component
public class CartHelper {
	private static CartRepository cRepo;
	private static int cartSize = 0;
	
	public CartHelper(CartRepository cRepo) {
		CartHelper.cRepo = cRepo;
	}
	public static Cart createOrRetrieveCart(Model model, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = cRepo.save(new Cart());
			request.getSession().setAttribute("cart", cart);
		}
		else {
			cart = cRepo.findById(cart.getId()).get();
		}
		model.addAttribute("cart", cart);
		return cart;	
	}
	
	public static Cart createOrRetrieveCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = cRepo.save(new Cart());
			request.getSession().setAttribute("cart", cart);
		}
		else {
			cart = cRepo.findById(cart.getId()).get();
		}

		return cart;	
	}
	
	public static Cart createAndReplaceCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart = cRepo.findById(cart.getId()).get();
		cart = cRepo.save(new Cart());
		request.getSession().setAttribute("cart", cart);

		return cart;	
	}
	
	
	public static int getCartSize() {
		return cartSize;
	}
	
	public static void setCartSize(int cartSize) {
		CartHelper.cartSize = cartSize;
	}
	
	
}
