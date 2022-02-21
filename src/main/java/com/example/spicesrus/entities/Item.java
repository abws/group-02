package com.example.spicesrus.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 * Represents an item
 * Each item will map to 1 spice
 * Each cart will have 1 or more items
 * Abstract base class
 * @author Abdiwahab
 * @version 1.0
 */
public abstract class Item {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(fetch = FetchType.LAZY) //unidirectional
	@JoinColumn(name = "spice_id")
	private Spices spice;
	
	
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

}
