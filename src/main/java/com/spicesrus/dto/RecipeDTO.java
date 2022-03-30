package com.spicesrus.dto;

import com.spicesrus.model.Recipes;
import com.spicesrus.model.Spices;

import java.util.List;

public class RecipeDTO {

    private String name;
    private String category;
    private String description;
    private String fullDescription;
    private String picture;
    private List<Spices> complimentarySpices;
    private String ingredients;
    private String method;
    private List<Recipes> complimentaryRecipes;
    private boolean restricted;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Recipes> getComplimentaryRecipes() {
        return complimentaryRecipes;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public List<Spices> getComplimentarySpices() {
        return complimentarySpices;
    }

    public void setComplimentarySpices(List<Spices> complimentarySpices) {
        this.complimentarySpices = complimentarySpices;
    }

    public void setComplimentaryRecipes(List<Recipes> complimentaryRecipes) {
        this.complimentaryRecipes = complimentaryRecipes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
