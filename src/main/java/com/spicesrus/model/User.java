package com.spicesrus.model;

import com.spicesrus.dto.UserDTO;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    private String username;

    @NotNull
    private String password;

    @Email
    private String email;

    private String firstName;
    private String lastName;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities = new ArrayList<>();

    public User() {

    }

    public User(UserDTO dto) {
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.authorities = dto.getAuthorities();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void grantAuthority(String authority) {
        this.authorities.add(authority);
    }

    private void revokeAuthority(String authority) {
        this.authorities.remove(authority);
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }


}

