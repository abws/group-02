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
import java.util.Optional;

import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Manages the recipes by searching with categories and sorting them.
 * 
 * 
 */

@Controller
public class RecipesController {
	@Autowired
	private RecipesRepository recipesRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SpicesRepository spicesRepo;

	//searching for all recipes 
	@RequestMapping("/recipes")
	public String Recipes(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		Iterable<Recipes> recipeListFromDatabase = recipesRepo.findAll();
		model.addAttribute("recipes", recipeListFromDatabase);
		return "recipe_overview";
	}
	
	//searching for the recipes in breakfast category 
	@GetMapping("/recipes/Breakfast")
	public String showCategory_B(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = SpicesrusApplication.recipes;
		List<Recipes> output = new ArrayList<Recipes>();
		for (Recipes r : recipes) {
			if (r.getCategory() == "Breakfast") {
				output.add(r);
			}
		}
		model.addAttribute("path", "Relevant");
		model.addAttribute("recipes", output);

		return "recipe_overview";
	}
	//searching for the recipes in lunch category 
	@GetMapping("/recipes/Lunch")
	public String showCategory_L(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = SpicesrusApplication.recipes;
		List<Recipes> output = new ArrayList<Recipes>();
		for (Recipes r : recipes) {
			if (r.getCategory() == "Lunch") {
				output.add(r);
			}
		}
		model.addAttribute("path", "Relevant");
		model.addAttribute("recipes", output);

		return "recipe_overview";
	}
	//searching for the recipes in Dinner category 
	@GetMapping("/recipes/Dinner")
	public String showCategory_D(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = SpicesrusApplication.recipes;
		List<Recipes> output = new ArrayList<Recipes>();
		for (Recipes r : recipes) {
			if (r.getCategory() == "Dinner") {
				output.add(r);
			}
		}
		model.addAttribute("path", "Relevant");
		model.addAttribute("recipes", output);

		return "recipe_overview";
	}
	//searching for the recipes in Cakes and Pies category 
	@GetMapping("/recipes/Cakes_and_Pies")
	public String showCategory_CaP(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = SpicesrusApplication.recipes;
		List<Recipes> output = new ArrayList<Recipes>();
		for (Recipes r : recipes) {
			if (r.getCategory() == "Cakes and Pies") {
				output.add(r);
			}
		}
		model.addAttribute("path", "Relevant");
		model.addAttribute("recipes", output);

		return "recipe_overview";
	}
	//searching for the recipes in pastries category 
	@GetMapping("/recipes/Pastries")
	public String showCategory_P(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = SpicesrusApplication.recipes;
		List<Recipes> output = new ArrayList<Recipes>();
		for (Recipes r : recipes) {
			if (r.getCategory() == "Pastries") {
				output.add(r);
			}
		}
		model.addAttribute("path", "Relevant");
		model.addAttribute("recipes", output);

		return "recipe_overview";
	}
	//sorting the recipes by the names from a to z  
	@GetMapping("/recipes/a-z")
	public String sort_a(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
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
		return "recipe_overview";
	}
	//sorting the recipes by the names from z to a 
	@GetMapping("/recipes/z-a")
	public String sort_z(Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
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
		return "recipe_overview";
	}

	@GetMapping("/recipesearch")
	public String search(Model model, @RequestParam String recipe, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Recipes> recipes = recipesRepo.findByNameContainingIgnoreCase(recipe);
		model.addAttribute("recipes", recipes);
		return "recipe_overview";

	}

	@GetMapping("/userspicesearch")
	public String searchspice(Model model, @RequestParam String spices, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		String[] items = spices.split(",");
		List<String> itemList = Arrays.asList(items);
		ArrayList<Spices> spiceList = new ArrayList<Spices>();
		for (String spice : itemList) {
			spiceList.add(spicesRepo.findByName(spice));
		}

		List<Recipes> recipesToAdd = new ArrayList<Recipes>();
		for (Spices item : spiceList) {
			List<Recipes> recipesContainingSpice = recipesRepo.findBySpicesInvolvedContaining(item);
			recipesToAdd.addAll(recipesContainingSpice);
		}
		model.addAttribute("recipes", recipesToAdd);
		return "recipe_overview";
	}

	/**
	 * Checks if a spice exists in the database. Shows the spice to user Couldn't
	 * handle "/recipes?..." requests as its implemented elsewhere
	 *
	 * @param recipe
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/recipe") // by default manages get requests
	public String showRecipe(@RequestParam String recipe, Model model, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		Recipes r = recipesRepo.findByName(recipe); // same as finding by id since the name is the id
		model.addAttribute("recipe", r);

		if (r.isRestricted()) {
			if (principal == null) {
				return "restricted_page";
			}
			Optional<User> query = userRepository.findByUsername(principal.getName());
			User user = query.get();
			if (!user.getAuthorities().contains("NOVICE") && !user.getAuthorities().contains("EXPERT")) {
				return "restricted_recipe";
			}
		}

		// just in case user types the recipe name into the url
		if (r != null)
			model.addAttribute("recipe", r);
		else
			return "recipe-not-found-page"; // needs to be implemented
		return "recipe";
	}
}
