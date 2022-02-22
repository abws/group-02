package com.example.spicesrus.repo;

import com.example.spicesrus.entities.Recipes;
import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipes, String> {

    public Recipes findByName(String name);
}

