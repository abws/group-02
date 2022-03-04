package com.example.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.spicesrus.entities.Recipes;
import com.example.spicesrus.repo.RecipesRepository;

@Controller
public class CartController {
	@Autowired
	RecipesRepository rRepo;
	
	@GetMapping("/cart")
	public String getCart(HttpServletRequest request) {
		Recipes r1 = new Recipes();
    	r1.setCategory("Pastries");
    	r1.setDescription("");
    	r1.setName("Cinnamon Buns");
    	r1.setPicture("https://www.cookingclassy.com/wp-content/uploads/2020/09/mini-cinnamon-rolls-21.jpg");
    	r1 = rRepo.save(r1);
		//request.getSession().setAttribute("cart", r1.getName());
    	
		request.getSession().setAttribute("cart", r1);
		Recipes x = (Recipes) request.getSession().getAttribute("cart");
		//String x = (String) request.getSession().getAttribute("cart");

		//Recipes y = rRepo.findByName(x);
		System.out.println(x);
		
		return "/";
	}
	
	@PutMapping("/cart")
	public String addItem(@RequestParam String name) {
		return "cart";
	}

}
