package com.example.spicesrus.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.Orders;

public interface BillingDetailsRepo extends CrudRepository<BillingDetails, Integer> {
	
	public Optional<BillingDetails> findById(Integer id);

}
