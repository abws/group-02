package com.example.spicesrus.controller;

import java.util.List;

import com.example.spicesrus.entities.Spices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpicesController {
	
	@RequestMapping("/spices")
	public String Spices(Model model) {
		List<Spices> spiceListFromDatabase = null; //Add this from Database
		model.addAttribute("spices", spiceListFromDatabase );
		return "allSpices";
	}

}
