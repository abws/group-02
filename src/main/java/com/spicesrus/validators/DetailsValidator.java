package com.spicesrus.validators;

import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.UDetails;
import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DetailsValidator implements Validator {

    private UserRepository userRepository;

    // Pass an instance of repository.
    public DetailsValidator(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO ud = (UserDTO) target;

        if (ud.getEmail() != null && userRepository.findByEmail(ud.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is already registered with us.");
        }
        if (ud.getUsername() != null && userRepository.findByUsername(ud.getUsername()) != null) {
            errors.rejectValue("username", "", "This username is taken.");
        }

        if (ud.getPassword().length() > 16 || ud.getPassword().length() < 8) {
            errors.rejectValue("password", "password", "The password must be between 8-16 characters");
        }

        if (!ud.getPassword().equals(ud.getConfirmedPassword())) {
            errors.rejectValue("confirmedPassword", "password2", "The passwords do not match");
        }


    }

}
