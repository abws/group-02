package com.example.spicesrus.controller;

import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;
import com.example.spicesrus.security.UDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

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
