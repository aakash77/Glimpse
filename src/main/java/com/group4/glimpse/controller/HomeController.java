package com.group4.glimpse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	/**
	 * Dummy Home Page
	 * @param model
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage( Model model) {
		System.out.println("Home");
		return "index";
	}
	
}
