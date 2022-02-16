package com.example.spicesrus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.spicesrus.security.UDetails;

@Entity
public class Basket {
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private UDetails user;
	
	private List<Spices> items;

	public List<Spices> getItems() {
		return items;
	}

	public void setItems(List<Spices> items) {
		this.items = items;
	}
	
	public void addItems(Spices spice) {
		this.items.add(spice);
	}
	
	public void deleteItems(Spices spice) {
		this.items.remove(spice);
	}
}
