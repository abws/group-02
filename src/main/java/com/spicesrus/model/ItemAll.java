package com.spicesrus.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Represents an item
 * Each item will map to 1 spice
 * Each cart will have 1 or more items
 * Abstract class
 * @author Abdiwahab
 * @version 1.0
 */

@Entity
public abstract class ItemAll {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(fetch = FetchType.LAZY) //unidirectional
	@JoinColumn(name = "spice_id")
	private Spices spice;
	private int quantity;
	private Unit unit;
	@Transient //transient annotation stops these fields from being persisted
	private double priceMetric;
	private double priceImperial;
	
	
	/**
	 * Makes the software more efficient by applying the calculations 
	 * only once after the object is loaded from the database instead of
	 * calling them every time
	 */
	/*Currently not working
	@PostLoad
	private void postLoad() {		 
		//spice price is for every 100g, hence the division
		this.price = weightInGrams * (this.spice.getPrice() / 100);
	}
	*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spices getSpice() {
		return spice;
	}

	public void setSpice(Spices spice) {
		this.spice = spice;
	}

	public abstract double getPrice();

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract String getWeight();

}
