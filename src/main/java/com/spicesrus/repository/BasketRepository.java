package com.spicesrus.repository;

import com.spicesrus.model.Basket;

import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
    public Basket findById(int id);
    public Basket findByUser(String name);
}
