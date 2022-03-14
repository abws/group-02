package com.spicesrus.repository;

import com.spicesrus.model.Recipes;
import org.springframework.data.repository.CrudRepository;

public interface RecipesRepository extends CrudRepository<Recipes, String> {

    public Recipes findByName(String name);
}

