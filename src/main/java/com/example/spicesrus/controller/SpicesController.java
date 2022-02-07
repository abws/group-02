package com.example.spicesrus.controller;

import com.example.spicesrus.repo.SpicesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpicesController {
	@Autowired
	private SpicesRepository spicesRepo;
	
	@RequestMapping("/spices")
	public String Spices(Model model) {
		Iterable<com.example.spicesrus.entities.Spices> spiceListFromDatabase = spicesRepo.findAll(); 
		model.addAttribute("spices", spiceListFromDatabase );
		return "allSpices";
	}

}
