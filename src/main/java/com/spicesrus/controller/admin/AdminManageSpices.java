package com.spicesrus.controller.admin;

import com.spicesrus.dto.SpicesDTO;
import com.spicesrus.dto.UserDTO;
import com.spicesrus.model.Spices;
import com.spicesrus.model.User;
import com.spicesrus.repository.SpicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/manage/spices")
public class AdminManageSpices {

    @Autowired
    private SpicesRepository spicesRepository;

    @RequestMapping("")
    public String index(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("searched", query != null);
        SpicesDTO dto;

        if (query != null) {
            Spices spice = spicesRepository.findByName(query);
            if (spice == null) {
                dto = new SpicesDTO();
            } else {
                dto = spice.toDTO();
            }
            model.addAttribute("selectedComp", dto.getComplimentarySpices());

        } else {
            dto = new SpicesDTO();
        }
        model.addAttribute("spiceDTO", dto);


        model.addAttribute("allSpices", spicesRepository.findAll());
        return "admin/manage_spices";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "spiceDTO") SpicesDTO dto) {
        Spices current = spicesRepository.findByName(dto.getName());

        if (current == null) {
            return "redirect:/admin/manage/spices";
        }

        current.setDescription(dto.getDescription());
        current.setCategory(dto.getCategory());
        current.setPicture(dto.getPicture());
        current.setPrice(dto.getPrice());
        current.setComplimentarySpices(dto.getComplimentarySpices());
        spicesRepository.save(current);
        return "redirect:/admin/manage/spices";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "spiceDTO") SpicesDTO dto) {
        Spices newSpice = new Spices();
        newSpice.setName(dto.getName());
        newSpice.setDescription(dto.getDescription());
        newSpice.setCategory(dto.getCategory());
        newSpice.setPicture(dto.getPicture());
        newSpice.setPrice(dto.getPrice());
        newSpice.setComplimentarySpices(dto.getComplimentarySpices());
        spicesRepository.save(newSpice);
        return "redirect:/admin/manage/spices";
    }

}
