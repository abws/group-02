package com.spicesrus.controller.security;

import com.spicesrus.model.User;
import com.spicesrus.repository.ForgottenPasswordRepo;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.service.EmailHandler;
import com.spicesrus.dto.ForgottenPasswordDTO;
import com.spicesrus.model.UDetails;
import com.spicesrus.repository.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import java.util.Optional;

@Controller
public class ResetPasswordController {

    @Autowired
    private UDetailsRepo repo;

    @Autowired
    private UserRepository userRepository;

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
        Optional<User> query = userRepository.findByUsername(dto.getUsername());
        User user = query.get();
        if (user == null) {
            return "security/lost-password";
        }
        if (user.getEmail().equals(dto.getEmail())) {
            try {
                handler.dispatchEmail(user.getEmail(), "Password Reset", "Password Reset Code: " + dto.getToken());
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

        Optional<User> query = userRepository.findByUsername(matching.getUsername());
        User user = query.get();
        user.setPassword(encoder.encode(dto.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
