package com.example.spicesrus.security;

import org.springframework.data.repository.CrudRepository;


public interface UDetailsRepo extends CrudRepository<UDetails,String> {

    public UDetails findByUsername(String login);
}
