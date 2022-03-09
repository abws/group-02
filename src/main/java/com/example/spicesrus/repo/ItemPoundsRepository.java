package com.example.spicesrus.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.ItemPounds;

public interface ItemPoundsRepository extends CrudRepository<ItemPounds, Integer> {
	public Item findById(int id);
	public ItemPounds findBySpiceName(String name);

}
