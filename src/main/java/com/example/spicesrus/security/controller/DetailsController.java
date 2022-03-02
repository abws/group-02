package com.example.spicesrus.security.controller;

import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DetailsController {

    @Autowired
    private UDetailsRepo repo;

    @GetMapping("/user")
    public String User(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login"; // If there is no available user data redirect to login.
        }

        UDetails user = repo.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user_detail";
    }

}
