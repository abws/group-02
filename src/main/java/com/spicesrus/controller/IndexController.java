package com.spicesrus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Manages all requests to the homepage
 * @author
 * @version 1
 */
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model, HttpServletRequest request) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		return "index/home";
	}
	
	/**
	 * For testing purposes only!
	 * Before closing the application,
	 * enter this endpoint to avoid
	 * any data mismatch problems later,
	 * especially for those using cart.
	 * Also do this for every relaunch of app
	 */
	@RequestMapping("/end")
		public String endSession(HttpSession s) {
			s.invalidate();
			return "redirect:/";
		}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		return "index/home";
	}

}


