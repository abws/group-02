package com.spicesrus.repository;

import org.springframework.data.repository.CrudRepository;
import com.spicesrus.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    public Orders findById(int id);
}
