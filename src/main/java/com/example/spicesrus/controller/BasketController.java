package com.example.spicesrus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spicesrus.entities.Basket;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.BasketRepository;
import com.example.spicesrus.repo.SpicesRepository;
import com.example.spicesrus.SpicesrusApplication;

@Controller
public class BasketController {
	@Autowired
	private SpicesRepository spiceRepo;
	
	@Autowired
	private BasketRepository basketRepo;
	
	@RequestMapping("/Basket/{name}")
	public String addToBasket(Model model, @PathVariable("name") String name) {
		Spices spicetoAdd = spiceRepo.findByName(name);
		Basket b = basketRepo.findById(0);
		b.addItems(spicetoAdd);
		return "redirect:../spices";
	}
	
	@RequestMapping("/Basket/Remove/{name}")
	public String RemoveFromBasket(Model model, @PathVariable("name") String name) {
		Spices spicetoDelete = spiceRepo.findByName(name);
		Basket b = basketRepo.findById(0);
		b.deleteItems(spicetoDelete);
		return "redirect:../basket";
	}
	
	@GetMapping("/Basket")
	public String showBasket(Model model) {
		return "basket";
	}
	
	
}