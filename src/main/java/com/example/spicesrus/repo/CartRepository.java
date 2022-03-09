package com.example.spicesrus.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spicesrus.entities.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
	public Cart findById(int id);
}
