package com.example.spicesrus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.spicesrus.security.UDetails;

@Entity
public class Basket {
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private UDetails user;
	
	@OneToMany
	@JoinColumn
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItems(Item item) {
		this.items.add(item);
	}
	
	public void deleteItems(Item item) {
		this.items.remove(item);
	}
}
