package com.spicesrus.controller;

import com.spicesrus.SpicesrusApplication;
import com.spicesrus.model.Recipes;
import com.spicesrus.model.Spices;
import com.spicesrus.model.User;
import com.spicesrus.repository.RecipesRepository;
import com.spicesrus.repository.SpicesRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipesController {
    @Autowired
    private RecipesRepository recipesRepo;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SpicesRepository spicesRepo;

    @RequestMapping("/recipes")
    public String Recipes(Model model) {
        Iterable<Recipes> recipeListFromDatabase = recipesRepo.findAll();
        model.addAttribute("recipes", recipeListFromDatabase);
        return "allRecipes";
    }

    @GetMapping("/recipes/Breakfast")
    public String showCategory_B(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            if (r.getCategory() == "Breakfast") {
                output.add(r);
            }
        }
        model.addAttribute("path", "Relevant");
        model.addAttribute("recipes", output);

        return "allRecipes";
    }

    @GetMapping("/recipes/Lunch")
    public String showCategory_L(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            if (r.getCategory() == "Lunch") {
                output.add(r);
            }
        }
        model.addAttribute("path", "Relevant");
        model.addAttribute("recipes", output);

        return "allRecipes";
    }

    @GetMapping("/recipes/Dinner")
    public String showCategory_D(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            if (r.getCategory() == "Dinner") {
                output.add(r);
            }
        }
        model.addAttribute("path", "Relevant");
        model.addAttribute("recipes", output);

        return "allRecipes";
    }

    @GetMapping("/recipes/Cakes and Pies")
    public String showCategory_CaP(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            if (r.getCategory() == "Cakes and Pies") {
                output.add(r);
            }
        }
        model.addAttribute("path", "Relevant");
        model.addAttribute("recipes", output);

        return "allRecipes";
    }

    @GetMapping("/recipes/Pastries")
    public String showCategory_P(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            if (r.getCategory() == "Pastries") {
                output.add(r);
            }
        }
        model.addAttribute("path", "Relevant");
        model.addAttribute("recipes", output);

        return "allRecipes";
    }

    @GetMapping("/recipes/a-z")
    public String sort_a(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<String> names = new ArrayList<String>();
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            names.add(r.getName());
        }
        Collections.sort(names);
        for (String n : names) {
            for (Recipes r : recipes) {
                if (r.getName() == n) {
                    output.add(r);
                }
            }
        }
        model.addAttribute("recipes", output);
        model.addAttribute("path", "A-Z");
        return "allRecipes";
    }

    @GetMapping("/recipes/z-a")
    public String sort_z(Model model) {

        List<Recipes> recipes = SpicesrusApplication.recipes;
        List<String> names = new ArrayList<String>();
        List<Recipes> output = new ArrayList<Recipes>();
        for (Recipes r : recipes) {
            names.add(r.getName());
        }
        Collections.sort(names, Collections.reverseOrder());
        for (String n : names) {
            for (Recipes r : recipes) {
                if (r.getName() == n) {
                    output.add(r);
                }
            }
        }

        model.addAttribute("recipes", output);
        model.addAttribute("path", "Z-A");
        return "allRecipes";
    }


    @GetMapping("/recipesearch")
    public String search(Model model, @RequestParam String recipe) {
        List<Recipes> recipes = recipesRepo.findByNameContainingIgnoreCase(recipe);
        model.addAttribute("recipes", recipes);
        return "allRecipes";

    }
    
    @GetMapping("/userspicesearch")
    public String searchspice(Model model, @RequestParam String spices) {
    	String[] items = spices.split(" ");
        List<String> itemList = Arrays.asList(items);
        List<Recipes> recipes = SpicesrusApplication.recipes;
        ArrayList<Recipes> recipesToAdd = new ArrayList<Recipes>();
    	for (String item: itemList) {
    		Spices spiceToLookFor = spicesRepo.findByName(item);
    		for (Recipes recipe: recipes) {
    			if (recipe.getSpicesInvolved() == null){
    				continue;
    			}
    			else if (recipe.getSpicesInvolved().contains(spiceToLookFor)){
    				recipesToAdd.add(recipe);
    			}
    		}
    	}
    	model.addAttribute("recipes", recipesToAdd);
        return "allRecipes";
    }

    /**
     * Checks if a spice exists in the database.
     * Shows the spice to user
     * Couldn't handle "/recipes?..." requests as its implemented elsewhere
     *
     * @param recipe
     * @param model
     * @return "spice" jsp page
     */
    @RequestMapping("/recipe") //by default manages get requests
    public String showRecipe(@RequestParam String recipe, Model model, Principal principal) {
        Recipes r = recipesRepo.findByName(recipe); //same as finding by id since the name is the id
        model.addAttribute("recipe", r);

        if (r.isRestricted()) {
            if (principal == null) {
                return "redirect:/login";
            }
            User user = userRepository.findByUsername(principal.getName());
            if (!user.getAuthorities().contains("NOVICE") && !user.getAuthorities().contains("EXPERT")) {
				return "restricted_recipe";
            }
        }


        //just in case user types the recipe name into the url
        if (r != null)
            model.addAttribute("recipe", r);
        else
            return "recipe-not-found-page"; //needs to be implemented
        return "recipe";
    }
}

