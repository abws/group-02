package com.example.spicesrus.security;

import org.springframework.data.repository.CrudRepository;

import com.example.spicesrus.entities.Orders;

public interface BillingDetailsRepo extends CrudRepository<BillingDetails, String> {
	
//	public Orders findById(Integer id);

}
