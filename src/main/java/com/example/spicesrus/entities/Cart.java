package com.example.spicesrus.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn
	private Map<Item, Integer> itemsMapQuantity = new LinkedHashMap<>();
	
	@Transient //we don't want to persist the price as it can be generated on-load
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Item, Integer> getItemsMapQuantity() { //getItems.add() will allow adding items. getItems.remove() will allow us to remove items
		return itemsMapQuantity;
	}

	public void setItemsMapQuantity(Map<Item, Integer> itemsMapQuantity) {
		this.itemsMapQuantity = itemsMapQuantity;
	}
	
	/**
	 * Loops through linkedhashmap and calculates total price of spices
	 * @return a price
	 */
	public double getPrice() { //loop through each item and return total price of them
		double total = 0;
		
		for (Map.Entry<Item, Integer> entry : itemsMapQuantity.entrySet()) {
			double itemTotalPrice = entry.getKey().getPrice() * entry.getValue(); //mulitple individual spice price by quantity
			total += itemTotalPrice;
		}
		this.price = total;
		return price;
	}

}
