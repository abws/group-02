package com.spicesrus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Manages all requests to the homepage
 * @author
 * @version 1
 */
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		String username = principal != null ? principal.getName() : null;
		model.addAttribute("username", username);
		return "index/index";
	}
	

}
