package com.spicesrus.controller.admin;

import com.spicesrus.model.User;
import com.spicesrus.repository.OrdersRepository;
import com.spicesrus.repository.RecipesRepository;
import com.spicesrus.repository.SpicesRepository;
import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.PostLoad;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {


    @Autowired
    private SpicesRepository spicesRepository;
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("")
    public String index(Model model) {
        int total_spices = (int) spicesRepository.count();
        int registered = (int) userRepository.count();
        int total_recipes = (int) recipesRepository.count();
        int total_restricted = recipesRepository.findAllByRestricted(true).size();
        int novice_users = (int) userRepository.findAll().stream().filter(user -> user.getAuthorities().contains("NOVICE")).count();
        int expert_users = (int) userRepository.findAll().stream().filter(user -> user.getAuthorities().contains("EXPERT")).count();

        model.addAttribute("total_spices", total_spices);
        model.addAttribute("registered", registered);
        model.addAttribute("total_recipes", total_recipes);
        model.addAttribute("total_restricted_recipes", total_restricted);
        model.addAttribute("novice_users", novice_users);
        model.addAttribute("expert_users", expert_users);
        return "admin/admin_index";
    }

}
