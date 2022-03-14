package com.spicesrus.controller;

import com.spicesrus.model.Recipes;
import com.spicesrus.repository.RecipesRepository;


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
        Iterable<Recipes> recipeListFromDatabase = recipesRepo.findAll();
        model.addAttribute("recipes", recipeListFromDatabase);
        return "allRecipes";
    }

}
	
	