package com.spicesrus.repository;

import java.util.Optional;

import com.spicesrus.model.BillingDetails;
import org.springframework.data.repository.CrudRepository;

public interface BillingDetailsRepo extends CrudRepository<BillingDetails, Integer> {
	
	public Optional<BillingDetails> findById(Integer id);

}
