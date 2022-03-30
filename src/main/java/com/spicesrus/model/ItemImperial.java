package com.spicesrus.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Child class of Item
 * Represents items in imperial format
 * @author Abdiwahab
 *
 */
@Entity
public class ItemImperial extends Item{
	private int pounds;
	private int ounces;
	@Transient //"don't persist this value, we'll calculate it on the server-side as needed"
	private double price;
	
	public int getPounds() {
		return pounds;
	}

	public void setPounds(int pounds) {
		this.pounds = pounds;
	}

	public int getOunces() {
		return ounces;
	}

	public void setOunces(int ounces) {
		this.ounces = ounces;
	}

	public double getPrice() {
		//convert pounds and ounces to grams and then multiply by standard per gram
		this.price = (((this.pounds * 16) + this.ounces) * 28.3495) * (getSpice().getPrice() / 100);
		this.price = this.price * this.getQuantity();
		this.price = Math.round(this.price * 100.0) / 100.0; //round to 2 decimal places
		return price;
	}

	@Override
	public String toString() {
		if (this.pounds == 0)
			return this.ounces + " lb";
		else
			return this.pounds + " lb " + this.ounces + " oz.";
	}
	
	@Override
	public String getWeight() {
		return this.pounds + "lbs" + this.ounces + "oz.";
	}
}
