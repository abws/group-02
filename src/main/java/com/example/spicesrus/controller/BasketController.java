package com.example.spicesrus.controller;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.Basket;

public interface BasketController extends CrudRepository<Basket, Integer>{
	public Basket findById(int id);
}
