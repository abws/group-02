package com.example.spicesrus.repo;

import com.example.spicesrus.entities.Basket;

import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, String> {

    public Basket findByUser(String name);
}
