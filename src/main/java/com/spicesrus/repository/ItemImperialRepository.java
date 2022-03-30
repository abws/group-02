package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spicesrus.model.Item;
import com.spicesrus.model.ItemImperial;

public interface ItemImperialRepository extends CrudRepository<ItemImperial, Integer> {
	public Item findById(int id);
	public ItemImperial findBySpiceName(String name);

}
