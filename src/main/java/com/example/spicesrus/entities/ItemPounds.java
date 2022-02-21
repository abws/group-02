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
	private int stones;
	private double pounds;
	@Transient //transient annotation stops these fields from being persisted
	private double price;
	
	public int getStones() {
		return stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public double getPounds() {
		return pounds;
	}

	public void setPounds(double pounds) {
		//round pounds to 2 decimal places
		this.pounds = Math.round(pounds * 100.0) / 100.0;
	}

	public double getPrice() {
		//convert convert stones and pounds to grams and then multiply by standard
		this.price = (((this.stones * 16) + this.pounds) * 454) * (getSpice().getPrice() / 100);
		return price;
	}

	@Override
	public String toString() {
		if (this.stones == 0)
			return getSpice().getName() + ":" + this.pounds + " pounds";
		else
			return getSpice().getName() + ":" + this.stones + " st " + this.pounds + " Ib";
	}
}
