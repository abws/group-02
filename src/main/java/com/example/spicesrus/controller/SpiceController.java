package com.example.spicesrus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spicesrus.entities.Spices;

/**
 * Manages all requests to the homepage
 * @author Abdiwahab
 * @version 1
 */
@Controller
public class SpiceController {
	@RequestMapping("/spices") //by default manages get requests
	public String showSpice(@RequestParam Spices spice) {
		return null;
		
	}
	

}
