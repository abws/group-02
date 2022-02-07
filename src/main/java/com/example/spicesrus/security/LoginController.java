package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UDetailsRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new UDetailsValidator());
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UDetails());
        return "register";
    }

    // ** Testing that you cant access this page without a login.
    @GetMapping("/restricted/loginsuccess")
    public String loginSuccess() {
        return "example-restricted";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") UDetails details, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        details.setPassword(encoder.encode(details.getPassword()));
        details.setConfirmedPassword(null);
        repo.save(details);
        return "register-success";
    }


}
