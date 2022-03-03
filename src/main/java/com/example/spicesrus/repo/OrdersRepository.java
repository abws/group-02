package com.example.spicesrus.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.spicesrus.entities.Orders;
import com.example.spicesrus.entities.Spices;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    public Orders findById(int id);
}
