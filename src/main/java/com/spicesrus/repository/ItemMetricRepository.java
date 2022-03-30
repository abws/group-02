package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spicesrus.model.Item;
import com.spicesrus.model.ItemMetric;

public interface ItemMetricRepository extends CrudRepository<ItemMetric, Integer> {
	public Item findById(int id);
	public ItemMetric findBySpiceName(String name);

}
