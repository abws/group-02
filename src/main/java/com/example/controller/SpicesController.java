package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Spices;

@Controller
public class SpicesController {
	
	@RequestMapping("/spices")
	public String Spices(Model model) {
		List<Spices> spiceListFromDatabase = null; //Add this from Database 
		model.addAttribute("spices", spiceListFromDatabase );
		return "allSpices";
	}

}
