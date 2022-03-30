package com.spicesrus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * A class to represent a shopping cart
 * @author Abdiwahab
 * @version 1
 *
 */
@Entity
public class Cart  implements Serializable {
	/**
	 * Session attribute needs to serialise and deserialise all cart objects
	 */
	private static final long serialVersionUID = 7809850254467550842L;

	@Id
	@GeneratedValue
	private int id; //a session will point to a basket
	
	@OneToMany (mappedBy="cart",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
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

	public double getUserPrice() {
		double total = 0;

		for (Item i : items) {
			total += i.getUserPrice();
		}
		this.price = total;
		return price;
	}

}
