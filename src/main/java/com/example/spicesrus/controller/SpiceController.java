package com.example.spicesrus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.SpicesRepository;

/**
 * Manages all requests to the homepage
 * @author Abdiwahab
 * @version 1
 */
@Controller
public class SpiceController {
	@Autowired
	SpicesRepository sRepo;
	
	@RequestMapping("/spices") //by default manages get requests
	public String showSpice(@RequestParam Spices spice, Model model) {
		Spices s = sRepo.findByName(spice.getName()); //same as finding by id since the name is the id
		model.addAttribute("spice", s);
		return "spice";
		
	}
	

}
