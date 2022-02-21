package com.example.spicesrus.entities;

import javax.persistence.Transient;

/**
 * Child class of Item
 * Represents items in pound format
 * @author
 *
 */
public class ItemPounds extends Item{
	private double weightInPounds;
	@Transient //transient annotation stops these fields from being persisted
	private double price;

	public double getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(double weightInPounds) {
		//round pounds to 2 decimal places
		this.weightInPounds = Math.round(weightInPounds * 100.0) / 100.0;
	}

	public double getPrice() {
		//convert weight into grams and then multiply by the standard
		this.price = (weightInPounds * 454) * (getSpice().getPrice() / 100);
		return price;
	}

	@Override
	public String toString() {
		
		Integer quotient = Math.floorMod(getWeightInPounds() / 1000);
		Integer remainder = getWeightInGrams() % 1000;
		
		if (quotient == 0)
			return getSpice().getName() + ":" + getWeightInGrams() + "grams";
		else
			return getSpice().getName() + ":" + quotient.toString() + "kg " + remainder.toString() + "g";
	}
}
