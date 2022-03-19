package com.spicesrus.validators;

import com.spicesrus.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Valid;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO dto = (UserDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "registration_first_name_empty", "First name must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "registration_last_name_empty", "Last name must not be empty");

        if (dto.getUsername().length() < 4 || dto.getUsername().length() > 16) {
            errors.rejectValue("username", "registration_username_length", "Username length must be between 4-16 characters");
        }

        if (dto.getPassword().length() < 4 || dto.getPassword().length() > 16) {
            errors.rejectValue("password", "registration_password_length", "Password length must be between 4-16 characters");
        }

        if (!dto.getConfirmedPassword().equals(dto.getPassword())) {
            errors.rejectValue("confirmedPassword", "registration_password_mismatch", "The passwords do not match");
        }
    }
}
