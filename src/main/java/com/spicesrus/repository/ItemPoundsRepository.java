package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spicesrus.model.Item;
import com.spicesrus.model.ItemPounds;

public interface ItemPoundsRepository extends CrudRepository<ItemPounds, Integer> {
	public Item findById(int id);
	public ItemPounds findBySpiceName(String name);

}
