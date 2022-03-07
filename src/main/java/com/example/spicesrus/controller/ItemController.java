package com.example.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spicesrus.entities.Cart;
import com.example.spicesrus.entities.Item;
import com.example.spicesrus.entities.ItemGrams;
import com.example.spicesrus.entities.ItemPounds;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.ItemGramsRepository;
import com.example.spicesrus.repo.ItemPoundsRepository;
import com.example.spicesrus.repo.ItemRepository;
import com.example.spicesrus.repo.SpicesRepository;

/**
 * Manages the creation and destruction of item objects, and adding them to a cart
 * @author 
 * version 3
 */

@Controller
public class ItemController {
	
	@Autowired //for creating a new item
	ItemRepository iRepo;
	@Autowired //for displaying the spice
	SpicesRepository sRepo;
	
	/**
	 * Individual spice page
	 * Checks if a spice exists in the database.
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
	 * Form takes us here
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemGrams")
	public String addItem(@ModelAttribute ItemGrams item, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getItems().add(item);
		
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId());
		System.out.println(i.getPrice());
		return "redirect:/spices";
		
	}
	
	/**
	 * Adds an item in pounds to database
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemPounds")
	public String addItem(@ModelAttribute ItemPounds item, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getItems().add(item);

		Item i = iRepo.save(item);
		i = iRepo.findById(item.getId());
		System.out.println(item.getPrice());
		return "redirect:/spices";	
	}
	
	@PostMapping("deleteItem")
	public String deleteItem(@RequestParam int id) {
		Item i = iRepo.findById(id);
		iRepo.deleteById(i.getId());

		return "redirect:/cart";
		
	}

}
