package com.spicesrus.repository;

import com.spicesrus.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
    User findByEmail(String email);
}
