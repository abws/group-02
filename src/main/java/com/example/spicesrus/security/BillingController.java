package com.example.spicesrus.security;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.Context;

@Controller
public class BillingController {
	
	@Autowired
	private BillingDetailsRepo repo;
	
	@Autowired
    private PasswordEncoder encoder;
	
	@Autowired
	private EmailHandler handler;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new BillingValidator(repo));
    }
	
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
	        try {
	        	Context context = new Context();
	        	context.setVariable("firstName", details.getFirstName());
	            handler.dispatchEmail(details.getCustomerEmail(), "Billing Confirmation", "billing_template.html", context);
	        }catch (MessagingException e) {
	            e.printStackTrace();
	        } 
	        return "order-complete";
	    }
	
}
