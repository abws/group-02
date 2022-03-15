package com.spicesrus.controller;

import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class MembershipController {

    @Autowired
    private UserRepository repo;
    @Autowired
    private UserService service;

    @GetMapping("/membership")
    public String membership() {
        return "membership_overview";
    }

    @PostMapping("/membership/basic")
    public String basic(Principal principal, HttpSession session) {
        if (principal == null) return "redirect:/login";
        User user = repo.findByUsername(principal.getName());
        user.getAuthorities().add("BASIC");
        user.getAuthorities().removeAll(List.of("NOVICE, EXPERT"));
        repo.save(user);
        service.update(user);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return "redirect:/user";
    }

    @PostMapping("/membership/novice")
    public String novice(Principal principal, HttpSession session) {
        if (principal == null) return "redirect:/login";
        User user = repo.findByUsername(principal.getName());
        user.getAuthorities().add("NOVICE");
        user.getAuthorities().removeAll(List.of("EXPERT", "BASIC"));
        repo.save(user);
        service.update(user);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return "redirect:/user";
    }

    @PostMapping("/membership/expert")
    public String expert(Principal principal, HttpSession session) {
        if (principal == null) return "redirect:/login";
        User user = repo.findByUsername(principal.getName());
        user.getAuthorities().add("EXPERT");
        user.getAuthorities().removeAll(List.of("NOVICE", "BASIC"));
        repo.save(user);
        service.update(user);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return "redirect:/user";
    }

    /*
    TODO Remove these once recipes are added.
     */
    @GetMapping("/novice")
    public String restrictedTest() {
        return "restricted_page";
    }
    @GetMapping("/expert")
    public String restrictedTestExpert() {
        return "restricted_page";
    }

}
