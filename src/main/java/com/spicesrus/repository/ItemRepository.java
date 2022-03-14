package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spicesrus.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	public Item findById(int id);
	public Item findBySpiceName(String name);

}