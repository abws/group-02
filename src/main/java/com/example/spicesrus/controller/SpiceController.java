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
	
	/**
	 * Checks if a spice exists in the database 
	 * and adds it to the model if it does
	 * Couldn't handle /spices?... requests as its implemented elsewhere
	 * @param spice
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/spice") //by default manages get requests
	public String showSpice(@RequestParam Spices spice, Model model) {
		Spices s = sRepo.findByName(spice.getName()); //same as finding by id since the name is the id
		
		//just in case user types the spice name into the url
		if (s != null)
			model.addAttribute("uniqueSpice", s);
		else
			return "spice-not-found-page"; //needs to be implemented
		
		return "spice";
		
	}
	

}
