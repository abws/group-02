package com.spicesrus.controller;

import java.security.Principal;
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
import com.spicesrus.model.ItemImperial;
import com.spicesrus.model.ItemMetric;
import com.spicesrus.model.Spices;
import com.spicesrus.model.User;
import com.spicesrus.repository.CartRepository;
import com.spicesrus.repository.ItemRepository;
import com.spicesrus.repository.SpicesRepository;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.service.CartHelper;

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
		model.addAttribute("itemImperial", new ItemImperial());
		model.addAttribute("itemMetric", new ItemMetric());
		
		
		//user privileges
		User userDetails = null;
		String level;
		
		if (user == null)
			level = "none";
		else {
			userDetails = uRepo.findByUsername(user.getName()).get();
			level = userDetails.getAuthorities().get(userDetails.getAuthorities().size() - 1);
		}
		
		model.addAttribute("level", level.toLowerCase());
	
		
		//in the case user types the spice name into the url
		if (s != null)
			model.addAttribute("spice", s);
		else
			return "spice-not-found-page";
		return "spice";	
	}	
	
	
	/**
	 * Adds an item in metric format to database
	 * Item form takes us here
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemMetric")
	public String addItemMetric(@ModelAttribute ItemMetric item, HttpServletRequest request) {
		
		Cart cart = CartHelper.createOrRetrieveCart(request);
		
		for(Item i : cart.getItems()) {
			if (item.getWeight().equals(i.getWeight()) && item.getSpice().getName().equals(i.getSpice().getName())) {
				if (item.getQuantity() + i.getQuantity() > 10) 
					i.setQuantity(10);
				else 
					i.setQuantity(item.getQuantity() + i.getQuantity());
				
				return "redirect:/spices";
			}
		}
		
		item.setCart(cart);

		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);
		
		item.setCart(cart);
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId());
		
		CartHelper.setCartSize(cart.getItems().size());
		return "redirect:/spices";
	}
	
	/**
	 * Adds an item in imperial format to database
	 * Item form takes us here
	 * @param item
	 * @return "spice" jsp page
	 */
	@PostMapping("addItemImperial")
		public String addItemPounds(@ModelAttribute ItemImperial item, HttpServletRequest request) {
			
		Cart cart = CartHelper.createOrRetrieveCart(request);
		
		for(Item i : cart.getItems()) {
			if (item.getWeight().equals(i.getWeight()) && item.getSpice().getName().equals(i.getSpice().getName())) {
				if (item.getQuantity() + i.getQuantity() > 10) 
					i.setQuantity(10);
				else 
					i.setQuantity(item.getQuantity() + i.getQuantity());
				return "redirect:/spices";
			}
		}
		
		item.setCart(cart);
	
		cart.getItems().add(item);
		request.getSession().setAttribute("cart", cart);
		
		item.setCart(cart);
		Item i = iRepo.save(item);
		i = iRepo.findById(i.getId());
		
		CartHelper.setCartSize(cart.getItems().size());
		return "redirect:/spices";
	}
}
