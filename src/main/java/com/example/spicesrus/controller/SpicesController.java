package com.example.spicesrus.controller;

import com.example.spicesrus.SpicesrusApplication;
import com.example.spicesrus.entities.Spices;
import com.example.spicesrus.repo.SpicesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/spices/Salts")
	public String showCategory_S(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			if (s.getCategory()=="Salts") {
				output.add(s);
			}
		}
		model.addAttribute("spices", output);
				
		return "allSpices";
	}
	
	@GetMapping("/spices/Peppers")
	public String showCategory_P(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			if (s.getCategory()=="Peppers") {
				output.add(s);
			}
		}
		model.addAttribute("spices", output);
				
		return "allSpices";
	}
	
	@GetMapping("/spices/Spice_Blends")
	public String showCategory_SB(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			if (s.getCategory()=="Spice Blends") {
				output.add(s);
			}
		}
		model.addAttribute("spices", output);
				
		return "allSpices";
	}
	
	@GetMapping("/spices/a-z")
	public String sort_a(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<String> names = new ArrayList<String>();
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			names.add(s.getName());			
		}
		Collections.sort(names);
		for (String n: names) {
			for (Spices s: spices) {
				if (s.getName()== n) {
					output.add(s);
				}
			}
		}
		model.addAttribute("spices", output);	
		return "allSpices";
	}
	
	@GetMapping("/spices/z-a")
	public String sort_z(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<String> names = new ArrayList<String>();
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			names.add(s.getName());			
		}
		Collections.sort(names,Collections.reverseOrder());
		for (String n: names) {
			for (Spices s: spices) {
				if (s.getName()== n) {
					output.add(s);
				}
			}
		}
		
		model.addAttribute("spices", output);	
		return "allSpices";
	}

	@GetMapping("/spices/price_asc")
	public String sort_asc(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<Double> prices = new ArrayList<Double>();
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			prices.add(s.getPrice());			
		}
		Collections.sort(prices);
		for (Double p: prices) {
			for (Spices s: spices) {
				if (s.getPrice()== p) {
					output.add(s);
				}
			}
		}
		
		model.addAttribute("spices", output);	
		return "allSpices";
	}
	
	@GetMapping("/spices/price_dsc")
	public String sort_dsc(Model model) {
		
		List<Spices> spices = SpicesrusApplication.spices;
		List<Double> prices = new ArrayList<Double>();
		List<Spices> output = new ArrayList<Spices>();
		for (Spices s: spices) {
			prices.add(s.getPrice());			
		}
		Collections.sort(prices,Collections.reverseOrder());
		for (Double p: prices) {
			for (Spices s: spices) {
				if (s.getPrice()== p) {
					output.add(s);
				}
			}
		}
		
		model.addAttribute("spices", output);	
		return "allSpices";
	}
	
	

}
