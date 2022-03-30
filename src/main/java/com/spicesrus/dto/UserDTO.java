package com.spicesrus.dto;

import com.spicesrus.model.User;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String username;

    @Email(message = "That email is not valid")
    private String email;

    private String password;
    private String confirmedPassword;
    private String firstName;
    private String lastName;
    private List<String> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public static UserDTO fromUser(User user) {
        UserDTO dto = new UserDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        List<String> role = new ArrayList<>();

        if (user.getAuthorities().contains("ADMIN")) {
            role.add("ADMIN");
        } else if (user.getAuthorities().contains("EXPERT")) {
            role.add("EXPERT");
        } else if (user.getAuthorities().contains("NOVICE")) {
            role.add("NOVICE");
        } else {
            role.add("BASIC");
        }

        dto.setAuthorities(role);
        dto.setPassword(""); // Password is hashed
        return dto;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmedPassword='" + confirmedPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
