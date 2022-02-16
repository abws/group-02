package com.example.spicesrus.repo;

import com.example.spicesrus.entities.Basket;

import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
    public Basket findById(int id);
    public Basket findByUser(String name);
}
