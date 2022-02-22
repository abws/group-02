package com.example.spicesrus.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.ItemGrams;
import com.example.spicesrus.entities.ItemPounds;

public interface ItemGramsRepository extends CrudRepository<ItemGrams, Integer> {
	public ItemGrams findBySpiceName(String name);

}
