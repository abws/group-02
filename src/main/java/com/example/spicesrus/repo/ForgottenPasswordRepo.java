package com.example.spicesrus.repo;

import com.example.spicesrus.security.ForgottenPasswordDTO;
import org.springframework.data.repository.CrudRepository;

public interface ForgottenPasswordRepo extends CrudRepository<ForgottenPasswordDTO, String> {

    ForgottenPasswordDTO findByToken(String token);
}
