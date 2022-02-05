package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Spices;

public interface SpicesRepository extends CrudRepository<Spices, String>{}
