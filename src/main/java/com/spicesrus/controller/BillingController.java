package com.spicesrus.controller;

import java.security.Principal;

import javax.mail.MessagingException;
import javax.validation.Valid;

import com.spicesrus.validators.BillingValidator;
import com.spicesrus.model.BillingDetails;
import com.spicesrus.repository.BillingDetailsRepo;
import com.spicesrus.service.CartHelper;
import com.spicesrus.service.EmailHandler;
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
import javax.servlet.http.HttpServletRequest;


/**The billing controller links to the billing form page.
 * It encodes and saves billing information for payment processing.
 * @author Haleem
 *
 */

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
	  public String billing(Model model, Principal principal) {
		 	String username = principal != null ? principal.getName() : null;
			model.addAttribute("username", username);
	        model.addAttribute("billing", new BillingDetails());
	        return "billing";
	    }
	 
	 @RequestMapping(value = "/billing", method = RequestMethod.POST)
	    public String billing(Principal principal, Model model, @Valid @ModelAttribute("billing") BillingDetails details, 
								BindingResult result, HttpServletRequest request) {
		 	String username = principal != null ? principal.getName() : null;
			model.addAttribute("username", username);
		 	if (result.hasErrors()) {
	            return "billing";
	        }
	         
	        // encode all sensitive billing information 
	        details.setCardNumber(encoder.encode(details.getCardNumber()));
	        details.setCvvNumber(encoder.encode(details.getCvvNumber()));
	        details.setExpiryDate(encoder.encode(details.getExpiryDate()));
	        repo.save(details);
	        //Sends a billing confirmation email using billing template HTML once the user submits the form.
	        try {	
	        	Context context = new Context();
	        	context.setVariable("firstName", details.getFirstName());
	        	context.setVariable("customerAddress", details.getCustomerAddress());
	        	context.setVariable("customerPostcode", details.getCustomerPostcode());
				context.setVariable("cart", CartHelper.createOrRetrieveCart(request));
	            handler.dispatchEmail(details.getCustomerEmail(), "Billing Confirmation", "billing_template.html", context);
	        }catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        
	        CartHelper.createAndReplaceCart(request);
	        CartHelper.setCartSize(0);
	        return "order-complete";
	    }
	
}
