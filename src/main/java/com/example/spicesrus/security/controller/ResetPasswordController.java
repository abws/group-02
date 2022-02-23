package com.example.spicesrus.security.controller;

import com.example.spicesrus.repo.ForgottenPasswordRepo;
import com.example.spicesrus.security.EmailHandler;
import com.example.spicesrus.security.ForgottenPasswordDTO;
import com.example.spicesrus.security.UDetails;
import com.example.spicesrus.security.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;

@Controller
public class ResetPasswordController {

    @Autowired
    private UDetailsRepo repo;

    @Autowired
    private ForgottenPasswordRepo fpr;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EmailHandler handler;

    @GetMapping("/lost-password")
    public String forgottenPassword(Model model) {
        model.addAttribute("dto", new ForgottenPasswordDTO());
        return "security/lost-password";
    }

    @PostMapping("/lost-password")
    public String lostPassword(@ModelAttribute(name = "dto") ForgottenPasswordDTO dto) {
        UDetails ud = repo.findByUsername(dto.getUsername());

        if (ud == null) {
            return "security/lost-password";
        }
        if (ud.getEmail().equals(dto.getEmail())) {
            try {
                handler.dispatchEmail(ud.getEmail(), "Password Reset", "Password Reset Code: " + dto.getToken());
                fpr.save(dto);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return "security/reset-password";
    }

    @GetMapping("/reset-password")
    public String resetPassword(Model model) {
        model.addAttribute("dto", new ForgottenPasswordDTO("tmp")); // Use a placeholder dto to collect form input
        return "security/reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@ModelAttribute(name = "dto") ForgottenPasswordDTO dto) {
        ForgottenPasswordDTO matching = fpr.findByToken(dto.getProvidedToken());

        if (matching == null) {
            return "redirect:/lost-password?error";
        }

        if (matching.isExpired()) {
            return "redirect:/lost-password?expired";
        }

        UDetails details = repo.findByUsername(matching.getUsername());
        details.setPassword(encoder.encode(dto.getPassword()));
        repo.save(details);
        return "redirect:/login";
    }
}
