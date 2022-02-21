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
		this.price = Math.round((weightInPounds * 454) * (getSpice().getPrice() / 100) * 100.0) / 100.0;
		return price;
	}

	@Override
	public String toString() {
		
		Integer quotient = (int) Math.floor(getWeightInPounds()) / 16;
		Double remainder = getWeightInPounds() % 1000;
		
		if (quotient == 0)
			return getSpice().getName() + ":" + remainder + "pounds";
		else
			return getSpice().getName() + ":" + quotient.toString() + "st " + remainder.toString() + "Ib";
	}
}
