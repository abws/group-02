package com.example.spicesrus.entities;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Child class of Item
 * Represents items in pound format
 * @author
 *
 */
@Entity
public class ItemPounds extends Item{
	private int pounds;
	private int ounces;
	@Transient //transient annotation stops these fields from being persisted
	private double price;
	
	public int getPounds() {
		return pounds;
	}

	public void setPounds(int ounces) {
		this.ounces = ounces;
	}
	
	public int getOunces() {
		return this.ounces;
	}


	public void setOunces(int ounces) {
		this.ounces = ounces;
	}

	public double getPrice() {
		//convert convert stones and pounds to grams and then multiply by standard
		this.price = (((this.pounds * 16) + this.ounces) * 28.3495) * (getSpice().getPrice() / 100);
		this.price = Math.round(this.price * 100.0) / 100.0; //round to 2 decimal places
		return price;
	}

	@Override
	public String toString() {
		if (this.pounds == 0)
			return getSpice().getName() + ":" + this.ounces + " lb";
		else
			return getSpice().getName() + ":" + this.pounds + " lb " + this.pounds + " oz.";
	}
}
