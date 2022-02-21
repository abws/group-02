package com.example.spicesrus.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	private int id;
	private String BasketId;
	private Date orderDate;
	private int quantity;
	private float orderTotal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getBasketId() {
		return BasketId;
	}
	public void setBasketId(String basketId) {
		BasketId = basketId;
	}	
	
}
