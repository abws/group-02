package com.example.spicesrus.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.ItemRepository;

/**
 * Manages all requests to the homepage
 * @author Abdiwahab
 * @version 1
 */
@Controller
public class SpiceController {
	@Autowired
	ItemRepository iRepo;
	
	/**
	 * Checks if a spice exists in the database 
	 * and adds it to the model if it does
	 * Couldn't handle /spices?... requests as its implemented elsewhere
	 * @param spice
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/spice") //by default manages get requests
	public String showSpice(@RequestParam String spice, Model model) {
		Item i = iRepo.findBySpiceName(spice); //same as finding by id since the name is the id
		
		//just in case user types the spice name into the url
		if (i != null)
			model.addAttribute("item", i);
		else
			return "spice-not-found-page"; //needs to be implemented
		
		return "spice";
		
	}	

}
