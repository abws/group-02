package com.example.spicesrus.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 * Represents an item
 * Each item will map to 1 product
 * Items will interact with cart
 * @author Abdiwahab
 * @version 1.0
 */
@Entity
public class Item {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn
	Spices spice;
	private int weightInGrams;
	@Transient //transient annotation stops these fields from being persisted
	private double weightInPounds;
	@Transient
	private double price;
	
	/**
	 * Makes the software more efficient by applying the calculations 
	 * only once after the object is loaded from the database instead of
	 * calling them every time
	 */
	@PostLoad
	private void postLoad() {
		this.weightInPounds = this.weightInGrams / 28.5;
		 
		//spice price is for every 100g, hence the division
		this.price = weightInGrams * (this.spice.getPrice() / 100);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spices getSpices() {
		return spice;
	}

	public void setSpices(Spices spice) {
		this.spice = spice;
	}

	public int getWeightInGrams() {
		return weightInGrams;
	}

	public void setWeightInGrams(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}

	public double getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(double weightInPounds) {
		this.weightInPounds = weightInPounds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
