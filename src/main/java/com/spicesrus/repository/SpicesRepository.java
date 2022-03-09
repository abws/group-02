package com.spicesrus.repository;

import com.spicesrus.model.Spices;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpicesRepository extends CrudRepository<Spices, String> {

    public Spices findByName(String name);
    public List<Spices> findByNameContainingIgnoreCase(String name);
}
