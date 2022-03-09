package com.example.spicesrus.entities;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Child class of Item
 * Represents items in gram format
 * @author Abdiwahab
 *
 */
@Entity
public class ItemGrams extends Item{
	private int kilograms;
	private int grams;
	@Transient //transient annotation stops these fields from being persisted
	private double price;
	
	public int getKilograms() {
		return kilograms;
	}

	public void setKilograms(int kilograms) {
		this.kilograms = kilograms;
	}

	public int getGrams() {
		return grams;
	}

	public void setGrams(int grams) {
		this.grams = grams;
	}

	public double getPrice() {
		//get the price of 1 gram and multiply it by the number of grams we have (LHS)
		this.price = ((kilograms * 1000) + grams) * (getSpice().getPrice() / 100);
		this.price = Math.round(this.price * 100.0) / 100.0; //round to 2 decimal places
		this.price *= this.price * this.getQuantity();
		return price;
	}

	@Override
	public String toString() {
		if (kilograms == 0)
			return getSpice().getName() + ":" + this.grams + "grams";
		else
			return getSpice().getName() + ":" + this.kilograms + "kg " + this.grams + "g";
	}

	@Override
	public String getWeight() {
		return this.kilograms + "kg " + this.grams + "g";
	}
}
