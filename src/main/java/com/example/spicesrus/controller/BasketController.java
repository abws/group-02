package com.example.spicesrus.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spicesrus.entities.Basket;
import com.example.spicesrus.entities.Item;
import com.example.spicesrus.repo.BasketRepository;
import com.example.spicesrus.repo.SpicesRepository;
import com.example.spicesrus.security.UDetails;


@Controller
public class BasketController {
	//@Autowired
	//private ItemRepository itemRepo;
	
	@Autowired
	private BasketRepository basketRepo;
	
	@RequestMapping("/Basket/{name}")
	public String Spices(Model model, @PathVariable("name") String name) {
		System.out.println(name);
		return "redirect:../spices";
	}
}