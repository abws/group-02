package com.spicesrus.controller.security;

import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.validators.DetailsValidator;
import com.spicesrus.model.UDetails;
import com.spicesrus.repository.UDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;

@Controller
public class DetailsController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new DetailsValidator(userRepository));
    }


    @GetMapping("/user")
    public String User(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login"; // If there is no available user data redirect to login.
        }


        User actual = userRepository.findByUsername(principal.getName());
        UserDTO dto = UserDTO.fromUser(actual);
        dto.setPassword("*******");

        model.addAttribute("user", dto);
        model.addAttribute("membership", Arrays.toString(actual.getAuthorities().toArray()));
        return "user_detail";
    }

    @PostMapping("/user")
    public String user(Principal principal, @Valid @ModelAttribute(name = "user") UserDTO user, BindingResult result, Model model) {

        BindingResult tmp = new BeanPropertyBindingResult(user, "user");
        UserDTO actual = UserDTO.fromUser(userRepository.findByUsername(principal.getName()));

        if (!principal.getName().equals(user.getUsername())) {
            result.reject("username", "You are not allowed to change your username"); // Prevents username being chnaged (Primary Key)
            return "user_details";
        }

        /*
        This below checks to see if the password is empty
        Then allows the user to proceed without needing to create a new validator
        or DTO for this page.
         */
        result.getFieldErrors().forEach(error -> {
            String field = error.getField();

            if (field.equals("email")) {
                if (error.getRejectedValue() != null && error.getRejectedValue().equals(actual.getEmail())) {
                    return; // User is not changing email.
                }
            }
            if (field.equals("username")) {
                if (error.getRejectedValue() != null && error.getRejectedValue().equals(principal.getName())) {
                    return; // Ignore duplicate username;
                }
            }

            if (field.equals("password") || field.equals("confirmedPassword")) {
                if (error.getRejectedValue() == null || error.getRejectedValue().toString().isEmpty()) {
                    user.setPassword(null);
                    return; // Passwords can be left empty if not being changed.
                }
            }

            tmp.addError(error); // All other errors need to be added.
        });

        // If there are any non-excluded errors
        if (tmp.hasErrors()) {
            model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "user", tmp); // Override the existing errors added to the model
            return "user_detail"; // return the form to the user
        }

        actual.setEmail(user.getEmail());
        actual.setFirstName(user.getFirstName());
        actual.setLastName(user.getLastName());

        if (user.getPassword() != null) {
            actual.setPassword(encoder.encode(user.getPassword()));
        }


        return "redirect:/user";
    }

}
