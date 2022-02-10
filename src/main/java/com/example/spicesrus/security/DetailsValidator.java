package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DetailsValidator implements Validator {

    private UDetailsRepo repo;

    // Pass an instance of repository.
    public DetailsValidator(UDetailsRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UDetails.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UDetails ud = (UDetails) target;

        if (ud.getUsername() != null && repo.findByUsername(ud.getUsername()) != null) {
            errors.rejectValue("username", "", "This username is taken.");
        }

        if (ud.getPassword().length() > 16 || ud.getPassword().length() < 8) {
            errors.rejectValue("password", "", "The password must be between 8-16 characters");
        }
        if (!ud.getPassword().equals(ud.getConfirmedPassword())) {
            System.out.println(ud.getPassword());
            System.out.println(ud.getConfirmedPassword());
            errors.rejectValue("confirmedPassword", "", "The passwords do not match");
        }


    }

}
