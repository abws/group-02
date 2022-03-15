package com.spicesrus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spicesrus.model.Cart;
import com.spicesrus.model.Item;
import com.spicesrus.repository.ItemGramsRepository;
import com.spicesrus.repository.ItemPoundsRepository;
import com.spicesrus.repository.ItemRepository;
import com.spicesrus.repository.RecipesRepository;

@Controller
public class CartController {
	@Autowired
	RecipesRepository rRepo;
	@Autowired 
	ItemGramsRepository igRepo;
	@Autowired 
	ItemPoundsRepository ipRepo;
	@Autowired
	ItemRepository iRepo;
	
	
	@GetMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
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
