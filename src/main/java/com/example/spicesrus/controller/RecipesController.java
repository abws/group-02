package com.example.spicesrus.controller;

import com.example.spicesrus.repo.RecipesRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipesController {
	@Autowired
	private RecipesRepository recipesRepo;
	
	@RequestMapping("/recipes")
	public String Recipes(Model model) {
		Iterable<com.example.spicesrus.entities.Recipes> recipeListFromDatabase = recipesRepo.findAll(); 
		model.addAttribute("recipes", recipeListFromDatabase );
		return "allRecipes";
	}
	
	}
	
	