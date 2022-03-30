package com.spicesrus.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spicesrus.model.Cart;
import com.spicesrus.model.Item;
import com.spicesrus.repository.CartRepository;

import com.spicesrus.repository.ItemRepository;
import com.spicesrus.repository.RecipesRepository;
import com.spicesrus.service.CartHelper;

@Controller
public class CartController {
	@Autowired
	RecipesRepository rRepo;

	@Autowired
	ItemRepository iRepo;

	@Autowired
	CartRepository cRepo;

	@GetMapping("/cart")
	public String showCart(HttpServletRequest request, Principal principal, Model model) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		CartHelper.createOrRetrieveCart(model, request);
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
		} else
			iRepo.delete(i);
		return "redirect:cart";
	}

	@PostMapping("deleteItem")
	public String deleteItem(@RequestParam int itemId, HttpServletRequest request) {
		Cart cart = CartHelper.createOrRetrieveCart(request);
		Item item = iRepo.deleteById(itemId);

		cart.getItems().forEach(i -> {
			if (i == item) {
				cart.getItems().remove(item);
				return;
			}
		});
		cRepo.save(cart);
		request.getSession().setAttribute("cart", cart);
		CartHelper.setCartSize(cart.getItems().size());

		return "redirect:/cart";
	}

}
