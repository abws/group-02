package com.example.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

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
 * Controller class managing items being added to cart 
 * @author Abdiwahab
 * @version 2
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
	 * Couldn't handle "/spices?..." requests as its implemented elsewhere
	 * @param spice
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/spice") //by default manages get requests
	public String showSpice(@RequestParam String spice, Model model) {
		Spices s = sRepo.findByName(spice); //same as finding by id since the name is the id
		model.addAttribute("spice", s);
		model.addAttribute("itemPound", new ItemPounds()); //CANNOT INSTANTIATE AN ITEM OBJECT!, whatever happened to that whole polymorphism stuff they were bragging about (would be nice if i could create a general object that gets specified after form is filled)
		model.addAttribute("itemGram", new ItemGrams());
		
		//just in case user types the spice name into the url
		if (s != null)
			model.addAttribute("spice", s);
		else
			return "spice-not-found-page"; //needs to be implemented
		return "spice";	
	}	
	
	/**
	 * Adds an item in grams to database
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemGrams")
	public String addItem(@ModelAttribute ItemGrams item, HttpServletRequest request) {
		request.getSession().setAttribute("hi", "hi");
		Item x = igRepo.save(item);
		x = igRepo.findById(x.getId()).get();
		System.out.println(x.getPrice());
		return "redirect:/spices";
		
	}
	
	/**
	 * Adds an item in pounds to database
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemPounds")
	public String addItem(@ModelAttribute ItemPounds item) {
		System.out.println(item.getPounds());
		Item x = ipRepo.save(item);
		x = ipRepo.findById(x.getId()).get();
		//System.out.println(x.getPrice());
		return "redirect:/spices";
		
	}

}
