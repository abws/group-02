package com.example.spicesrus.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Recipes {
	/**
	 * 
	 */
	@Id
	private String name;
	private String category;
	private String description;

	@OneToMany
	@JoinColumn
	private List<Recipes> complimentaryRecipes;
	private String picture;
	
	
	
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
	
}
