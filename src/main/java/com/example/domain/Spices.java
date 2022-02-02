package com.example.domain;

import java.util.List;

public class Spices {
	
	private String name;
	private String description;
	private Float price;
	private List<Spices> complimentarySpices;
	private String picture;
	
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
