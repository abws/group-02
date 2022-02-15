package com.example.spicesrus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

@Entity
public class Item {
	@Id
	@GeneratedValue
	int id;
	@OneToOne
	@JoinColumn
	String productId;
	int weightGrams;
	@Formula("weightGrams/28.35")
	double weightPounds;
	double price;

}
