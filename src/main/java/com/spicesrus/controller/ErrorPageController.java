package com.spicesrus.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**The error page controller give the error if the item can not be found.
*
*/
@Controller
public class ErrorPageController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		if (request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) != null) {
			int x = Integer.parseInt(String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)));
			if (x == HttpStatus.NOT_FOUND.value()) {
				model.addAttribute("errorType", "404");
			} else {
				model.addAttribute("errorType", "");
			}
		} else {
			model.addAttribute("errorType", "");
		}
		return "error";
	}
}
