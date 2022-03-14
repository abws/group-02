package com.spicesrus.controller;

import com.spicesrus.model.UDetails;
import com.spicesrus.repository.UDetailsRepo;
import com.spicesrus.service.UDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MembershipController {

    @Autowired
    private UDetailsRepo repo;

    @Autowired
    private UDetailsService service;

    @GetMapping("/membership")
    public String membership() {
        return "membership_overview";
    }

    @PostMapping("/membership/basic")
    public String basic(Principal principal) {
        if (principal == null) return "redirect:/login";
        UDetails user = repo.findByUsername(principal.getName());
        service.updateUser(user, "BASIC");
        return "redirect:/membership";
    }

    @PostMapping("/membership/novice")
    public String novice(Principal principal) {
        if (principal == null) return "redirect:/login";
        UDetails user = repo.findByUsername(principal.getName());
        service.updateUser(user, "NOVICE");
        return "redirect:/membership";
    }

    @PostMapping("/membership/expert")
    public String expert(Principal principal) {
        if (principal == null) return "redirect:/login";
        UDetails user = repo.findByUsername(principal.getName());
        service.updateUser(user, "EXPERT");
        return "redirect:/membership";
    }

    @GetMapping("/novice")
    public String restrictedTest() {
        return "restricted_page";
    }
    @GetMapping("/expert")
    public String restrictedTestExpert() {
        return "restricted_page";
    }

}