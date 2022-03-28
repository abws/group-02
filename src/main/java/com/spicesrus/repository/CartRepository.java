package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spicesrus.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	}
