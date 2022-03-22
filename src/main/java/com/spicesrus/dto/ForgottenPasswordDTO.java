package com.spicesrus.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ForgottenPasswordDTO {

    @Id
    private String token;
    private String username;
    private String email;

    private String password;
    private String confirmedPassword;

    private Long created;

    private String providedToken;

    public ForgottenPasswordDTO() {
        token = UUID.randomUUID().toString();
        created = System.currentTimeMillis();
    }

    public ForgottenPasswordDTO(String tmp) {
        this.token = tmp;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public Long getCreated() {
        return created;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() - created) > 3600*1000; // Expired if created more than 1 hour ago.
    }

    public String getProvidedToken() {
        return providedToken;
    }

    public void setProvidedToken(String providedToken) {
        this.providedToken = providedToken;
    }

    @Override
    public String toString() {
        return "ForgottenPasswordDTO{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmedPassword='" + confirmedPassword + '\'' +
                ", created=" + created +
                '}';
    }
}
