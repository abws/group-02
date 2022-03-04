package com.example.spicesrus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
	
	@GetMapping("/cart")
	public String getCart() {
		return "cart";
	}
	
	@PutMapping("/cart")
	public String addItem(@RequestParam String name) {
		return "cart";
	}

}
