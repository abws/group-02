package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spicesrus.model.Item;
import com.spicesrus.model.ItemGrams;

public interface ItemGramsRepository extends CrudRepository<ItemGrams, Integer> {
	public Item findById(int id);
	public ItemGrams findBySpiceName(String name);

}
