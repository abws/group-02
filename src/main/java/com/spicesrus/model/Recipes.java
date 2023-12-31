package com.spicesrus.model;

import com.spicesrus.dto.RecipeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.*;

@Entity
public class Recipes {
	/**
	 * A class to store all recipe information
	 * 
	 */
	@Id
	private String name;

	private String category;
	private String description;

	@Column(columnDefinition = "TEXT")
	private String FullDescription;

	private int timeRequired;
	private String minimumRoleRequired;

	@OneToMany
	@JoinColumn
	private List<Recipes> complimentaryRecipes = new ArrayList<Recipes>();
	private String picture;

	@OneToMany
	@JoinColumn
	private List<Spices> spicesInvolved;

	@ElementCollection
	private List<String> ingredients;
	@ElementCollection
	private List<String> method;

	private boolean restricted = false;

	public List<Spices> getSpicesInvolved() {
		return spicesInvolved;
	}

	public void setSpicesInvolved(List<Spices> spicesInvolved) {
		this.spicesInvolved = spicesInvolved;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getMethod() {
		return method;
	}

	public void setMethod(List<String> method) {
		this.method = method;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getFullDescription() {
		return FullDescription;
	}

	public void setFullDescription(String FullDescription) {
		this.FullDescription = FullDescription;
	}

	public List<Recipes> getComplimentaryRecipes() {
		return complimentaryRecipes;
	}

	public void setComplimentaryRecipes(List<Recipes> complimentaryRecipes) {
		this.complimentaryRecipes = complimentaryRecipes;
	}

	public void addComplimentaryRecipes(Recipes recipe) {
		this.complimentaryRecipes.add(recipe);
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}

	public boolean isRestricted() {
		return restricted;
	}

	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}

	public RecipeDTO toDTO() {
		RecipeDTO dto = new RecipeDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setDescription(description);
		dto.setFullDescription(FullDescription);
		dto.setPicture(picture);
		dto.setRestricted(restricted);
		StringBuilder methodBuidler = new StringBuilder();
		method.forEach(m -> methodBuidler.append(m + "\n"));
		StringBuilder ingBuilder = new StringBuilder();
		ingredients.forEach(i -> ingBuilder.append(i + "\n"));
		dto.setMethod(methodBuidler.toString());
		dto.setIngredients(ingBuilder.toString());
		dto.setComplimentaryRecipes(complimentaryRecipes);
		dto.setComplimentarySpices(spicesInvolved);
		return dto;
	}
}
