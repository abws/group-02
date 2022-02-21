package com.example.spicesrus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.ItemGrams;
import com.example.spicesrus.entities.ItemPounds;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.ItemGramsRepository;
import com.example.spicesrus.repo.ItemPoundsRepository;
import com.example.spicesrus.repo.SpicesRepository;

/**
 * Manages all requests to the homepage
 * @author Abdiwahab
 * @version 1
 */
@Controller
public class SpiceController {
	
	@Autowired //for creating a new item in pound format
	ItemPoundsRepository ipRepo;
	@Autowired //for creating a new item in gram format
	ItemGramsRepository igRepo;
	@Autowired //for displaying the spice
	SpicesRepository sRepo;
	
	/**
	 * Checks if a spice exists in the database.
	 * Shows the spice to user
	 * Couldn't handle /spices?... requests as its implemented elsewhere
	 * @param spice
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/spice") //by default manages get requests
	public String showSpice(@RequestParam String spice, Model model) {
		Spices s = sRepo.findByName(spice); //same as finding by id since the name is the id
		model.addAttribute("spice", s);
		model.addAttribute("itemPound", new ItemPounds()); //CANNOT INSTANTIATE AN ITEM OBJECT!
		model.addAttribute("itemGram", new ItemGrams());
		
		//just in case user types the spice name into the url
		if (s != null)
			model.addAttribute("spice", s);
		else
			return "spice-not-found-page"; //needs to be implemented
		return "spice";	
	}	
	
	/**
	 * Adds an item to the Item database
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItem")
	public String addItem(@ModelAttribute Item item) {
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId()).get();
		
		System.out.println(i.getPrice());
		return "redirect:/spices";
		
	}

}
