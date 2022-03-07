package com.example.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.spicesrus.entities.Cart;
import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.ItemGrams;
import com.example.spicesrus.entities.ItemPounds;
import com.example.spicesrus.entities.Recipes;
import com.example.spicesrus.repo.ItemGramsRepository;
import com.example.spicesrus.repo.ItemPoundsRepository;
import com.example.spicesrus.repo.RecipesRepository;

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
