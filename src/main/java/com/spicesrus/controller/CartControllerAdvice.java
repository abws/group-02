package com.spicesrus.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spicesrus.service.CartHelper;
/**The cart controller advice  manage to have multiple items in the cart .
*
*/
@ControllerAdvice
public class CartControllerAdvice {

	@ModelAttribute("cartSize")
	public int addCartSize() {
		return CartHelper.getCartSize();
	}

}
