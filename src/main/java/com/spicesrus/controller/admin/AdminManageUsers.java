package com.spicesrus.controller.admin;

import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("admin/manage/users")
public class AdminManageUsers {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("searched", false);
        model.addAttribute("userDTO" , new UserDTO());
        return "admin/manage_users";
    }

    @PostMapping
    public String manage() {
        return "redirect:/admin/manage/users"; // TODO implement this.
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String query) {
        model.addAttribute("searched", true);
        if (query.contains("@")) {
            Optional<User> q = userRepository.findByEmail(query);
            if (q.isPresent()) {
                User u = q.get();
                UserDTO dto = new UserDTO();
                dto.setUsername(u.getUsername());
                dto.setEmail(u.getEmail());
                dto.setFirstName(u.getFirstName());
                dto.setLastName(u.getLastName());
                model.addAttribute("userDTO", dto);
            } else {
                UserDTO dto = new UserDTO();
                dto.setEmail(query);
                model.addAttribute("userDTO", dto);
            }
            // search by email
        } else {
            Optional<User> q = userRepository.findByUsername(query);
            if (q.isPresent()) {
                User u = q.get();
                UserDTO dto = new UserDTO();
                dto.setUsername(u.getUsername());
                dto.setEmail(u.getEmail());
                dto.setFirstName(u.getFirstName());
                dto.setLastName(u.getLastName());
                model.addAttribute("userDTO", dto);
            } else {
                UserDTO dto = new UserDTO();
                dto.setUsername(query);
                model.addAttribute("userDTO", dto);
            }

        }

        return "admin/manage_users";
    }
}
