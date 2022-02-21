package com.example.spicesrus.entities;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Child class of Item
 * Represents items in gram format
 * @author
 *
 */
@Entity
public class ItemGrams extends Item{
	private int weightInGrams; //will be the default. if user writes it down in pounds, convert to grams on client-side
	@Transient //transient annotation stops these fields from being persisted
	private double price;
	
	public int getWeightInGrams() {
		return weightInGrams;
	}

	public void setWeightInGrams(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}

	public double getPrice() {
		this.price = weightInGrams * (getSpice().getPrice() / 100);
		return price;
	}

	@Override
	public String toString() {
		Integer quotient = Math.floorMod(getWeightInGrams() / 1000, getId());
		Integer remainder = getWeightInGrams() % 1000;
		
		if (quotient == 0)
			return getSpice().getName() + ":" + getWeightInGrams() + "grams";
		else
			return getSpice().getName() + ":" + quotient.toString() + "kg " + remainder.toString() + "g";
	}
}
