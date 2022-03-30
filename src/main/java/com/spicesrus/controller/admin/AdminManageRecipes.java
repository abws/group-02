package com.spicesrus.controller.admin;

import com.spicesrus.dto.RecipeDTO;
import com.spicesrus.model.Recipes;
import com.spicesrus.repository.RecipesRepository;
import com.spicesrus.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin/manage/recipes")
public class AdminManageRecipes {

    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private SpicesRepository spicesRepository;


    @RequestMapping("")
    public String index(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("searched", query != null);
        RecipeDTO dto;

        if (query != null) {
            Recipes recipe = recipesRepository.findByName(query);
            if (recipe == null) {
                dto = new RecipeDTO();
            } else {
                dto = recipe.toDTO();
            }
            model.addAttribute("selectedComp", dto.getComplimentarySpices());

        } else {
            dto = new RecipeDTO();
        }
        model.addAttribute("recipeDTO", dto);


        model.addAttribute("allRecipes", recipesRepository.findAll());
        model.addAttribute("allSpices", spicesRepository.findAll());
        return "admin/manage_recipes";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "recipeDTO") RecipeDTO dto) {
        Recipes current = recipesRepository.findByName(dto.getName());
        System.out.println("here");
        if (current == null) {
            return "redirect:/admin/manage/recipes";
        }
        current.setDescription(dto.getDescription());
        current.setFullDescription(dto.getFullDescription());
        current.setCategory(dto.getCategory());
        current.setPicture(dto.getPicture());
        current.setSpicesInvolved(dto.getComplimentarySpices());
        current.setComplimentaryRecipes(dto.getComplimentaryRecipes());
        current.setRestricted(dto.isRestricted());

        List<String> method = new ArrayList<>(Arrays.asList(dto.getMethod().split("\n")));
        List<String> ingredients = new ArrayList<>(Arrays.asList(dto.getIngredients().split("\n")));

        current.setMethod(method);
        current.setIngredients(ingredients);

        recipesRepository.save(current);
        return "redirect:/admin/manage/recipes";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "recipeDTO") RecipeDTO dto) {
        System.out.println("here 2");
        Recipes newRecipe = new Recipes();
        newRecipe.setDescription(dto.getDescription());
        newRecipe.setFullDescription(dto.getFullDescription());
        newRecipe.setCategory(dto.getCategory());
        newRecipe.setPicture(dto.getPicture());
        newRecipe.setSpicesInvolved(dto.getComplimentarySpices());
        newRecipe.setComplimentaryRecipes(dto.getComplimentaryRecipes());
        newRecipe.setRestricted(dto.isRestricted());
        newRecipe.setName(dto.getName());
        List<String> method = new ArrayList<>(Arrays.asList(dto.getMethod().split("\n")));
        List<String> ingredients = new ArrayList<>(Arrays.asList(dto.getIngredients().split("\n")));
        newRecipe.setMethod(method);
        newRecipe.setIngredients(ingredients);
        System.out.println(newRecipe);
        recipesRepository.save(newRecipe);
        return "redirect:/admin/manage/recipes";
    }

}
