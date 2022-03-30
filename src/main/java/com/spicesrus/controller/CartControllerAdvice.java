package com.spicesrus.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spicesrus.service.CartHelper;

/**
 * Adds a model attribute 'cartSize' for every request.
 * @author
 */
@ControllerAdvice
public class CartControllerAdvice {

	@ModelAttribute("cartSize")
	public int addCartSize() {
		return CartHelper.getCartSize();
	}

}
