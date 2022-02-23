package com.example.spicesrus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UDetailsRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailHandler handler;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new DetailsValidator(repo));
    }

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }

    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UDetails());
        return "security/register";
    }

    @RequestMapping("/confirmRegistration")
    public String completeRegistration(@Valid @ModelAttribute("user") UDetails details, BindingResult result) {
        if (result.hasErrors()) {
            return "security/register";
        }

        details.setConfirmedPassword(null); // No longer need to store this (Duplicated Value)
        details.setPassword(encoder.encode(details.getPassword()));
        repo.save(details);
        try {
            Context context = new Context();
            context.setVariable("username", details.getUsername());
            handler.dispatchEmail(details.getEmail(), "Registration Confirmation", "register_template.html", context);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
        return "security/register-success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") UDetails details, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "security/register";
        }

        model.addAttribute("details", details);
        return "security/register-confirm";
    }


}
