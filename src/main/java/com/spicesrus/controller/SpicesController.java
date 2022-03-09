package com.spicesrus.controller;

import com.spicesrus.SpicesrusApplication;
import com.spicesrus.model.Spices;
import com.spicesrus.repository.SpicesRepository;
import com.spicesrus.repository.UDetailsRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpicesController {
	@Autowired
	private SpicesRepository spicesRepo;
	
	@Autowired
	private UDetailsRepo uRepo;

	@RequestMapping("/spices")
	public String Spices(Model model) {
		Iterable<Spices> spiceListFromDatabase = spicesRepo.findAll();
		model.addAttribute("path", "Relevant");
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
		model.addAttribute("path", "Relevant");
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
		model.addAttribute("path", "Relevant");
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
		model.addAttribute("path", "Relevant");

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
		model.addAttribute("path", "A-Z");
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
		model.addAttribute("path", "Z-A");
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
		model.addAttribute("path", "Price Ascending");
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
		model.addAttribute("path", "Price Descending");

		model.addAttribute("spices", output);	
		return "allSpices";
	}
	

	
	@GetMapping("/spicesearch")
	public String search(Model model, @RequestParam String spice) {
		List<Spices> spices = spicesRepo.findByNameContainingIgnoreCase(spice);
		model.addAttribute("spices", spices);	
		return "allSpices";
		
	}
	
	
}
