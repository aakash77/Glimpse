package com.group4.glimpse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	/**
	 * Home Page
	 * @param model
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String homepage( Model model) {
		System.out.println("Home");
		return "index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLoginHomePage( Model model) {
		System.out.println("Login");
		return "login";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String getSignUpHomePage( Model model) {
		System.out.println("SignUp");
		return "signup";
	}
	
	
}
