package com.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spicesrus.model.Cart;
import com.spicesrus.repository.ItemGramsRepository;
import com.spicesrus.repository.ItemPoundsRepository;
import com.spicesrus.repository.RecipesRepository;

@Controller
public class CartController {
	@Autowired
	RecipesRepository rRepo;
	@Autowired 
	ItemGramsRepository igRepo;
	@Autowired 
	ItemPoundsRepository ipRepo;
	
	
	@GetMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		model.addAttribute(cart);
		return "cart";
	}
	


}
