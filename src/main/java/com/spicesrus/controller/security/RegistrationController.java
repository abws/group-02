package com.spicesrus.controller.security;

import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.validators.DetailsValidator;
import com.spicesrus.service.EmailHandler;
import com.spicesrus.repository.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.Context;

import java.security.Principal;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
public class RegistrationController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UDetailsRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailHandler handler;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new DetailsValidator(userRepository));
    }

    @RequestMapping(value = "/register")
    public String register(Model model, Principal principal) {
    	String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
        model.addAttribute("user", new UserDTO());
        return "security/register";
    }

    @RequestMapping("/confirmRegistration")
    public String completeRegistration(@Valid @ModelAttribute("user") UserDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "security/register";
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        userRepository.save(user);

        try {
            Context context = new Context();
            context.setVariable("username", user.getUsername());
            handler.dispatchEmail(user.getEmail(), "Registration Confirmation", "register_template.html", context);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "redirect:/membership";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") UserDTO dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "security/register";
        }

        model.addAttribute("details", dto);
        return "security/register-confirm";
    }

}

