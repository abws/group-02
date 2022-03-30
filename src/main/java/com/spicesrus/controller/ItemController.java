package com.spicesrus.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.spicesrus.model.*;
import com.spicesrus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Manages the creation and destruction of item objects, and adding them to a cart
 *
 * @author version 3
 */

@Controller
public class ItemController {

    @Autowired //for creating a new items in pounds
    ItemImperialRepository ipRepo;
    @Autowired //for creating new items in grams
    ItemMetricRepository igRepo;
    @Autowired //for displaying the spice
    SpicesRepository sRepo;
    @Autowired
    ItemRepository iRepo;
    @Autowired
    CartRepository cRepo;
    @Autowired
    UserRepository uRepo;


    /**
     * Individual spice page
     * Checks if a spice exists in the database.
     * Couldn't handle "/spices?..." requests as its implemented elsewhere
     *
     * @param spice
     * @param model
     * @return "spice" jsp page
     */
    @RequestMapping("/spice") //by default manages get requests
    public String showSpice(@RequestParam String spice, Model model, HttpServletRequest request, Principal user) {
        //get spice to view and item ready
        Spices s = sRepo.findByName(spice); //same as finding by id since the name is the id
        model.addAttribute("spice", s);
        model.addAttribute("itemPound", new ItemImperial()); //CANNOT INSTANTIATE AN ITEM OBJECT!, whatever happened to that whole polymorphism stuff they were bragging about (would be nice if i could create a general object that gets specified after form is filled)
        model.addAttribute("itemGram", new ItemMetric());

        //user privileges
        String level;

        if (user == null)
            level = "none";

        else {
            Optional<User> query = uRepo.findByUsername(user.getName());
            User userDetails = query.orElse(null);
            if (userDetails != null) {
                System.out.println(user.getName());
                level = userDetails.getAuthorities().get(userDetails.getAuthorities().size() - 1);
            }else{
                level = "none";
            }
        }
        //System.out.println(level.toLowerCase());
        model.addAttribute("level", level.toLowerCase());

        //session management
        if (request.getSession().getAttribute("cart") == null) {
            System.out.println("I'm here");
            Cart cart = new Cart();
            cart = cRepo.save(cart);

            request.getSession().setAttribute("cart", cart);
            //model.addAttribute("cart", cart);
            //model.addAttribute("cart-items", 0);
        } else {
            System.out.println("I'm here");
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            model.addAttribute("cart", cart);
            //int n = cart.getItems().size();
            //System.out.println(n);
            //model.addAttribute("cart-items", n);
        }


        //just in case user types the spice name into the url
        if (s != null)
            model.addAttribute("spice", s);
        else
            return "spice-not-found-page"; //needs to be implemented
        return "spice";
    }

    /**
     * Adds an item in grams to database
     * Form takes us here
     *
     * @param item
     * @return "spice" jsp page
     */
    @PostMapping("addItemGrams")
    public String addItemGrams(@ModelAttribute ItemMetric item, HttpServletRequest request) {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cRepo.findById(cart.getId()).isPresent())
            cart = cRepo.findById(cart.getId()).get();
        else
            cart = cRepo.save(cart);

        item.setCart(cart);

        cart.getItems().add(item);
        request.getSession().setAttribute("cart", cart);

        item.setCart(cart);
        Item i = iRepo.save(item);
        i = iRepo.findById(i.getId());
        System.out.println(item.getSpice().getName());
        System.out.println(i.getPrice());
        //return "redirect:/spice?spice=" + item.getSpice().getName(); //change to shop after testing
        return "redirect:/spices";

    }

    /**
     * Adds an item in pounds to database
     *
     * @param item
     * @return "spice" jsp page
     */
    @PostMapping("addItemPounds")
    public String addItemPounds(@ModelAttribute ItemImperial item, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getItems().add(item);
        request.getSession().setAttribute("cart", cart);

        item.setCart(cart);
        Item i = iRepo.save(item);
        i = iRepo.findById(item.getId());
        System.out.println(item.getSpice().getName());
        System.out.println(item.getPrice());
        //return "redirect:/spice?spice=" + item.getSpice().getName();
        return "redirect:/spices";
    }

	/*
	@PostMapping("deleteItem")
	public String deleteItem(@RequestParam int id) {
		Item i = iRepo.findById(id);
		iRepo.deleteById(i.getId());

		return "redirect:/cart";

	}
	*/

}
