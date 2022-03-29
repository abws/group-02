package com.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spicesrus.model.Cart;
import com.spicesrus.model.Item;
import com.spicesrus.repository.CartRepository;
import com.spicesrus.repository.ItemImperialRepository;
import com.spicesrus.repository.ItemMetricRepository;
import com.spicesrus.repository.ItemRepository;
import com.spicesrus.repository.RecipesRepository;

@Controller
public class CartController {
	@Autowired
	RecipesRepository rRepo;
	
	@Autowired
	ItemMetricRepository imRepo;
	
	@Autowired 
	ItemImperialRepository iiRepo;
	
	@Autowired
	ItemRepository iRepo;
	
	@Autowired
	CartRepository cRepo;
	
	
	@GetMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			cart = cRepo.save(cart);
			request.getSession().setAttribute("cart", cart);
		}
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart = cRepo.findById(cart.getId()).get();
		request.getSession().setAttribute("cart", cart);
		//System.out.println(cart.getItems().get(0).getQuantity() + "now"); //debugging
		
		model.addAttribute("cart", cart);
		return "cart/cart";
	}
	
	@PostMapping("increaseItem")
	public String increaseItem(@RequestParam int itemId, @RequestParam int quantity) {
		System.out.println(quantity);
		
		Item i = iRepo.findById(itemId);
		
		System.out.println(i);
	
		if (quantity > 0) {
			i.setQuantity(quantity);
			iRepo.save(i);
		}
		else
			iRepo.delete(i);
		return "redirect:cart";	
	}
	
	


}
