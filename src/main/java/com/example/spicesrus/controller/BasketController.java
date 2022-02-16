package com.example.spicesrus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spicesrus.entities.Basket;
import com.example.spicesrus.repo.BasketRepository;
import com.example.spicesrus.repo.SpicesRepository;
import com.example.spicesrus.security.UDetails;


@Controller
public class BasketController {
	@Autowired
	private BasketRepository basketRepo;
	
	@RequestMapping("/Basket")
	public String Spices(Model model) {
		UDetails user = new UDetails();//"Ask how is best to get this"
		Basket userBasket = basketRepo.findByUser(user.getUsername());
		List<com.example.spicesrus.entities.Spices> spicesInBasket = userBasket.getItems();
		model.addAttribute("spices", spicesInBasket);
		return "allSpices";
	}
}