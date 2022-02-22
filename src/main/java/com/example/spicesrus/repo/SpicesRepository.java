package com.example.spicesrus.repo;

import com.example.spicesrus.entities.Spices;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpicesRepository extends CrudRepository<Spices, String> {

    public Spices findByName(String name);
    public List<Spices> findByNameContainingIgnoreCase(String name);
}
