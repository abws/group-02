package com.spicesrus.repository;

import com.spicesrus.model.Recipes;
import com.example.spicesrus.entities.Recipes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipes, String> {

    public Recipes findByName(String name);

    public List<Recipes> findByNameContainingIgnoreCase(String name);
}

