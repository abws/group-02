package com.spicesrus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Basket {
	@Id
	@GeneratedValue
	private int id; //a session will point to a basket
	
	@OneToOne
	private UDetails user;
	
	@OneToMany
	@JoinColumn
	private List<Spices> items = new ArrayList<Spices>();

	public List<Spices> getItems() {
		return items;
	}

	public void setItems(List<Spices> items) {
		this.items = items;
	}
	
	public void addItems(Spices item) {
		this.items.add(item);
	}
	
	public void deleteItems(Spices item) {
		this.items.remove(item);
	}
}
