package com.example.spicesrus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Recipes {
	@Id
	private String name;
	private String category;
	private String description;
	private String ingredients;
	private String fullDescription;
	private String method;
	private int timeRequired;

	@OneToMany
	@JoinColumn
	private List<Recipes> complimentaryRecipes;
	private String picture;
	
	@OneToMany
	@JoinColumn
	private List<Spices> spicesInvolved;
	
	
	
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
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
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
	
}
