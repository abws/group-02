package com.spicesrus.controller;

import com.spicesrus.SpicesrusApplication;
import com.spicesrus.model.Cart;
import com.spicesrus.model.Spices;
import com.spicesrus.model.User;
import com.spicesrus.repository.CartRepository;
import com.spicesrus.repository.SpicesRepository;
import com.spicesrus.repository.UDetailsRepo;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.spicesrus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpicesController {
	@Autowired
	private SpicesRepository spicesRepo;
	@Autowired
	private CartRepository cRepo;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/spices")
	public String Spices(Principal principal, Model model,
			@RequestParam(name = "sort", required = false, defaultValue = "a-z") String sortType,
			HttpServletRequest request) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		Iterable<Spices> spiceListFromDatabase = spicesRepo.findAll();
		if (principal != null) {
			Optional<User> query = userRepository.findByUsername(principal.getName());
			User user = query.get();
			if (user.getAuthorities().contains("NOVICE") || user.getAuthorities().contains("EXPERT")) {
				model.addAttribute("isMember", true);
			} else {
				model.addAttribute("isMember", false);
			}
		} else {
			model.addAttribute("isMember", false);
		}
		List<Spices> displayed = new ArrayList<>();

		if (sortType.equals("salts")) {
			model.addAttribute("path", "Relevant");
			spiceListFromDatabase.forEach(spice -> {
				if (spice.getCategory().equals("Salts")) {
					displayed.add(spice);
				}
			});
		} else if (sortType.equals("peppers")) {
			model.addAttribute("path", "Relevant");
			spiceListFromDatabase.forEach(spice -> {
				if (spice.getCategory().equals("Peppers")) {
					displayed.add(spice);
				}
			});
		} else if (sortType.equals("spiceBlends")) {
			model.addAttribute("path", "Relevant");
			spiceListFromDatabase.forEach(spice -> {
				if (spice.getCategory().equals("Spice Blends")) {
					displayed.add(spice);
				}
			});
		} else if (sortType.equals("a-z")) {
			model.addAttribute("path", "A-Z");
			spiceListFromDatabase.forEach(displayed::add);
			displayed.sort(Comparator.comparing(Spices::getName));
		} else if (sortType.equals("z-a")) {
			model.addAttribute("path", "Z-A");
			spiceListFromDatabase.forEach(displayed::add);
			displayed.sort(Comparator.comparing(Spices::getName));
			Collections.reverse(displayed);
		} else if (sortType.equals("price_asc")) {
			model.addAttribute("path", "Price Ascending");
			spiceListFromDatabase.forEach(displayed::add);
			displayed.sort(Comparator.comparing(Spices::getPrice));
		} else if (sortType.equals("price_dsc")) {
			model.addAttribute("path", "Price Descending");
			spiceListFromDatabase.forEach(displayed::add);
			displayed.sort(Comparator.comparing(Spices::getPrice));
			Collections.reverse(displayed);
		} else {
			spiceListFromDatabase.forEach(displayed::add);
		}
		model.addAttribute("spices", displayed);

		return "spice_overview";
	}

	@GetMapping("/spicesearch")
	public String search(Model model, @RequestParam String spice, Principal principal) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		List<Spices> spices = spicesRepo.findByNameContainingIgnoreCase(spice);
		model.addAttribute("spices", spices);
		return "spice_overview";

	}

}
