package com.spicesrus.controller.admin;

import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/manage/users")
public class AdminManageUsers {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping
    public String index(Model model, @RequestParam(name = "query", required = false) String query) {
        model.addAttribute("searched", query != null);

        System.out.println("query=" + query);

        if (query != null) {
            if (query.contains("@")) {
                Optional<User> q = userRepository.findByEmail(query);
                if (q.isPresent()) {
                    User u = q.get();
                    UserDTO dto = UserDTO.fromUser(u);
                    model.addAttribute("userRole", dto.getAuthorities().get(0));
                    model.addAttribute("userDTO", dto);
                } else {
                    UserDTO dto = new UserDTO();
                    dto.setEmail(query);
                    model.addAttribute("userRole", "BASIC");
                    model.addAttribute("userDTO", dto);
                }
                // search by email
            } else {
                Optional<User> q = userRepository.findByUsername(query);
                if (q.isPresent()) {
                    User u = q.get();
                    UserDTO dto = UserDTO.fromUser(u);
                    model.addAttribute("userDTO", dto);
                    model.addAttribute("userRole", dto.getAuthorities().get(0));
                } else {
                    UserDTO dto = new UserDTO();
                    dto.setUsername(query);
                    model.addAttribute("userRole", "BASIC");
                    model.addAttribute("userDTO", dto);
                }

            }
        }else{
            model.addAttribute("userDTO" , new UserDTO());
        }

        System.out.println(model.getAttribute("userDTO"));
        model.addAttribute("roles", service.getRoles().stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList()));
        return "admin/manage_users";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "userDTO") UserDTO dto) {
        Optional<User> query = userRepository.findByUsername(dto.getUsername());
        if (query.isPresent())  {
            User actual = query.get();
            if (dto.getPassword() != null && dto.getPassword().length() != 0) {
                actual.setPassword(dto.getPassword());
            }
            if (dto.getEmail() != null && dto.getEmail().length() != 0) {
                actual.setEmail(dto.getEmail());
            }

            if (dto.getFirstName() != null && dto.getFirstName().length() != 0) {
                actual.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null && dto.getLastName().length() != 0) {
                actual.setFirstName(dto.getLastName());
            }

            String authority = dto.getAuthorities().get(0);
            actual.setAuthorities(List.of(authority));

            userRepository.save(actual); // save changes
        }
        return "redirect:/admin/manage/users"; // TODO implement this.
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "userDTO") UserDTO dto) {
        User user = new User(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        userRepository.save(user);
        return "redirect:/admin/manage/users";
    }

}
