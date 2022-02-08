package com.example.spicesrus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Spices {
	@Id
	private String name;
	private String category;
	private String description;
	private Double price;

	@OneToMany
	@JoinColumn
	private List<Spices> complimentarySpices;
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
	public List<Spices> getComplimentarySpices() {
		return complimentarySpices;
	}
	public void setComplimentarySpices(List<Spices> complimentarySpices) {
		this.complimentarySpices = complimentarySpices;
	}
	public void addComplimentarySpices(Spices spice) {
		this.complimentarySpices.add(spice);
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
}
