package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UDetailsRepo repo;
    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/register")
    public String register(Model model) {
        model.addAttribute("user", new UDetails());
        return "register";
    }



    // ** Testing that you cant access this page without a login.
    @GetMapping("/restricted/loginsuccess")
    public String loginSuccess() {
        return "example-restricted";
    }


    @PostMapping("/login/register")
    public String register(@ModelAttribute UDetails details) {
        if (repo.findByUsername(details.getUsername()) != null) {
            // User already exists
            return "register?error=exists";
        }

        if (!details.getPassword().equals(details.getConfirmedPassword())) {
            return "register?error=pw";
        }

        details.setPassword(encoder.encode(details.getPassword()));
        details.setConfirmedPassword(null);
        repo.save(details);
        return "register-success";
    }


}
