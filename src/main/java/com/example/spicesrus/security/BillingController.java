package com.example.spicesrus.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BillingController {
	
	@Autowired
	private BillingDetailsRepo repo;
	
	@Autowired
    private PasswordEncoder encoder;
	
	 @RequestMapping(value = "/billing")
	  public String billing(Model model) {
	        model.addAttribute("billing", new BillingDetails());
	        return "billing";
	    }
	 
	 @RequestMapping(value = "/billing", method = RequestMethod.POST)
	    public String billing(@Valid @ModelAttribute("billing") BillingDetails details, BindingResult result) {
	        if (result.hasErrors()) {
	            return "billing";
	        }
	         
	        details.setCardNumber(encoder.encode(details.getCardNumber()));
	        details.setCvvNumber(encoder.encode(details.getCvvNumber()));
	        details.setExpiryDate(encoder.encode(details.getExpiryDate()));
	        repo.save(details);
	        return "order-complete";
	    }
	
}
