package com.spicesrus.repository;

import com.spicesrus.dto.ForgottenPasswordDTO;
import org.springframework.data.repository.CrudRepository;

public interface ForgottenPasswordRepo extends CrudRepository<ForgottenPasswordDTO, String> {

    ForgottenPasswordDTO findByToken(String token);
}
