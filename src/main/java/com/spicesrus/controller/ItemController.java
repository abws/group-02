package com.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spicesrus.model.Cart;
import com.spicesrus.model.Item;
import com.spicesrus.model.ItemGrams;
import com.spicesrus.model.ItemPounds;
import com.spicesrus.model.Spices;
import com.spicesrus.repository.ItemGramsRepository;
import com.spicesrus.repository.ItemPoundsRepository;
import com.spicesrus.repository.SpicesRepository;

/**
 * Manages the creation and destruction of item objects, and adding them to a cart
 * @author 
 * version 3
 */

@Controller
public class ItemController {
	
	@Autowired //for creating a new items in pounds
	ItemPoundsRepository ipRepo;
	@Autowired //for creating new items in grams
	ItemGramsRepository igRepo;
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
	public String showSpice(@RequestParam String spice, Model model, HttpServletRequest request) {
		Spices s = sRepo.findByName(spice); //same as finding by id since the name is the id
		model.addAttribute("spice", s);
		model.addAttribute("itemPound", new ItemPounds()); //CANNOT INSTANTIATE AN ITEM OBJECT!, whatever happened to that whole polymorphism stuff they were bragging about (would be nice if i could create a general object that gets specified after form is filled)
		model.addAttribute("itemGram", new ItemGrams());
		
		if (request.getSession().getAttribute("cart") == null) 
			request.getSession().setAttribute("cart", new Cart());
		
		
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
	public String addItemGrams(@ModelAttribute ItemGrams item, HttpServletRequest request) {
				
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);
		
		Item i = igRepo.save(item);
		i = igRepo.findById(i.getId());
		System.out.println(item.getSpice().getName());
		System.out.println(i.getPrice());
		return "redirect:/spice?spice=" + item.getSpice().getName();
		
	}
	
	/**
	 * Adds an item in pounds to database
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemPounds")
	public String addItemPounds(@ModelAttribute ItemPounds item, HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);

		Item i = ipRepo.save(item);
		i = ipRepo.findById(item.getId());
		System.out.println(item.getSpice().getName());
		System.out.println(item.getPrice());
		return "redirect:/spice?spice=" + item.getSpice().getName();
	}
	
	/*
	@PostMapping("deleteItem")
	public String deleteItem(@RequestParam int id) {
		Item i = iRepo.findById(id);
		iRepo.deleteById(i.getId());

		return "redirect:/cart";
		
	}
	*/

}
