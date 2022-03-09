package com.example.spicesrus.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	public Item findById(int id);
	public Item findBySpiceName(String name);

}