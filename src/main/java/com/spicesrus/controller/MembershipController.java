package com.spicesrus.controller;

import com.spicesrus.model.User;
import com.spicesrus.repository.UserRepository;
import com.spicesrus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class MembershipController {

	@Autowired
	private UserRepository repo;
	@Autowired
	private UserService service;

	@GetMapping("/membership")
	public String membership(Principal principal, Model model) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		String membership;
		if (principal == null) {
			membership = "NONE";
		} else {
			Optional<User> query = repo.findByUsername(principal.getName());
			User user = query.get();
			if (user.getAuthorities().contains("EXPERT"))
				membership = "EXPERT";
			else if (user.getAuthorities().contains("ADMIN"))
				membership = "EXPERT"; // display admin as expert
			else if (user.getAuthorities().contains("NOVICE"))
				membership = "NOVICE";
			else if (user.getAuthorities().contains("BASIC"))
				membership = "BASIC";
			else
				membership = "NONE ";
		}

		model.addAttribute("membership", membership);
		return "membership_overview";
	}

	@PostMapping("/membership/basic")
	public String basic(Principal principal, HttpSession session) {
		if (principal == null)
			return "redirect:/login";
		Optional<User> query = repo.findByUsername(principal.getName());
		User user = query.get();
		user.getAuthorities().add("BASIC");
		user.getAuthorities().removeAll(List.of("NOVICE, EXPERT"));
		repo.save(user);
		service.update(user);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		return "redirect:/membership";
	}

	@PostMapping("/membership/novice")
	public String novice(Principal principal, HttpSession session) {
		if (principal == null)
			return "redirect:/login";
		Optional<User> query = repo.findByUsername(principal.getName());
		User user = query.get();
		user.getAuthorities().add("NOVICE");
		user.getAuthorities().removeAll(List.of("EXPERT", "BASIC"));
		repo.save(user);
		service.update(user);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		return "redirect:/membership";
	}

	@PostMapping("/membership/expert")
	public String expert(Principal principal, HttpSession session) {
		if (principal == null)
			return "redirect:/login";
		Optional<User> query = repo.findByUsername(principal.getName());
		User user = query.get();
		user.getAuthorities().add("EXPERT");
		user.getAuthorities().removeAll(List.of("NOVICE", "BASIC"));
		repo.save(user);
		service.update(user);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		return "redirect:/membership";
	}

	/*
	 * TODO Remove these once recipes are added.
	 */
	@GetMapping("/novice")
	public String restrictedTest() {
		return "restricted_page";
	}

	@GetMapping("/expert")
	public String restrictedTestExpert() {
		return "restricted_page";
	}

}
