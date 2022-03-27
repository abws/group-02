package com.spicesrus.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.spicesrus.model.UDetails;
import com.spicesrus.model.User;
import com.spicesrus.repository.CartRepository;
import com.spicesrus.repository.ItemGramsRepository;
import com.spicesrus.repository.ItemPoundsRepository;
import com.spicesrus.repository.ItemRepository;
import com.spicesrus.repository.SpicesRepository;
import com.spicesrus.repository.UDetailsRepo;
import com.spicesrus.repository.UserRepository;

/**
 * Manages the creation and destruction of item objects, and their addition to a cart
 * @author Abdiwahab
 * version 3
 */

@Controller
public class ItemController {
	@Autowired
	SpicesRepository sRepo;
	
	@Autowired
	ItemRepository iRepo;
	
	@Autowired
	CartRepository cRepo;
	
	@Autowired
	UserRepository uRepo;
	
	
	/**
	 * Individual spice page
	 * Checks if a spice exists in the database.
	 * Couldn't handle "/spices..." requests as its implemented elsewhere
	 * @param spice
	 * @param model
	 * @return "spice" jsp page
	 */
	@RequestMapping("/spice") //by default manages get requests
	public String showSpice(@RequestParam String spice, Model model, HttpServletRequest request, Principal user) {
		
		//get spice to view and item ready 
		Spices s = sRepo.findByName(spice); //same as finding by id since the name is the id
		model.addAttribute("spice", s);
		model.addAttribute("itemPound", new ItemPounds());
		model.addAttribute("itemGram", new ItemGrams());
		
		
		//user privileges
		User userDetails = null;
		String level;
		
		if (user == null)
			level = "none";
		else {
			userDetails = uRepo.findByUsername(user.getName());
			level = userDetails.getAuthorities().get(userDetails.getAuthorities().size() - 1);
		}
		
		model.addAttribute("level", level.toLowerCase());
	
		
		//session management
		if (request.getSession().getAttribute("cart") == null) {
			System.out.println("I'm here");
			Cart cart = new Cart();
			cart = cRepo.save(cart);
			
			request.getSession().setAttribute("cart", cart);
			model.addAttribute("cart", cart);
			model.addAttribute("items", 0);
		}
		
		/*
		 * Either end session or make sure cart is 
		 * instantiated with session cart as cart 
		 * database is dropped with every restart of application
		 */
		else {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart = cRepo.findById(cart.getId()).get();
			model.addAttribute("cart", cart);
			model.addAttribute("items", cart.getItems().size());
		}
		
		//just in case user types the spice name into the url
		if (s != null)
			model.addAttribute("spice", s);
		else
			return "spice-not-found-page";
		return "spice";	
	}	
	
	
	/**
	 * Adds an item in grams format to database
	 * Item form takes us here
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemGrams")
	public String addItemGrams(@ModelAttribute ItemGrams item, HttpServletRequest request) {
			
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cRepo.findById(cart.getId()).isPresent())
			cart = cRepo.findById(cart.getId()).get();
		else
			cart = cRepo.save(cart);
		item.setCart(cart);

		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);
		
		item.setCart(cart);
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId());

		return "redirect:/spice?spice=" + item.getSpice().getName(); //change to shop after testing
		//return "redirect:/spices";
	}
	
	/**
	 * Adds an item in pounds format to database
	 * Item form takes us here
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemPounds")
		public String addItemPounds(@ModelAttribute ItemPounds item, HttpServletRequest request) {
			
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cRepo.findById(cart.getId()).isPresent())
			cart = cRepo.findById(cart.getId()).get();
		else
			cart = cRepo.save(cart);
		item.setCart(cart);
	
		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);
		
		item.setCart(cart);
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId());
	
		return "redirect:/spice?spice=" + item.getSpice().getName(); //change to shop after testing
		//return "redirect:/spices";
	}
}
