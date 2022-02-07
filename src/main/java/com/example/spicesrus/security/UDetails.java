package com.example.spicesrus.security;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UDetails {

    @Id
    @Size(min = 4, max = 16, message = "A username must be between 4-16 characters")
    private String username;


    @NotNull
    private String password;

    @Transient
    private String confirmedPassword;

    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @Email
    private String email;


    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
class UDetailsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UDetails.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UDetails ud = (UDetails) target;

        if (ud.getPassword().length() > 16 || ud.getPassword().length() < 8) {
            errors.rejectValue("password", "", "The password must be between 8-16 characters");
        }
        if (!ud.getPassword().equals(ud.getConfirmedPassword())) {
            errors.rejectValue("confirmedPassword", "", "The passwords do not match");
        }


    }
}