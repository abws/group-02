package com.example.spicesrus.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * A class to represent user cart
 *
 */
@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int id; //a session will point to a basket
	
	@OneToMany
	@JoinColumn
	private List<Item> items = new ArrayList<>();
	
	@Transient //we don't want to persist the price as it can be generated on-load
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() { //getItems.add() will allow adding items. getItems.remove() will allow us to remove items
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getPrice() { //loop through each item and return total price of them
		double total = 0;
		
		for (Item i : items) {
			total += i.getPrice();
		}
		this.price = total;
		return price;
	}

}
