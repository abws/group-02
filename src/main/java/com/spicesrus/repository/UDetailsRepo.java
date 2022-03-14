package com.spicesrus.repository;

import com.spicesrus.model.UDetails;
import org.springframework.data.repository.CrudRepository;


public interface UDetailsRepo extends CrudRepository<UDetails,String> {

    public UDetails findByUsername(String login);
    public UDetails findByEmail(String email);

}
