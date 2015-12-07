package com.group4.glimpse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Group 4
 * View controller
 */
@Controller
@RequestMapping(value = "/")
public class ViewController {

	/**
	 * Return Home(Index) Page (Model)
	 * @param model
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String homepage( Model model) {
		return "index";
	}
	
	/**
	 * Return Login Page (Model)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLoginHomePage( Model model) {
		return "login";
	}

	/**
	 * Return Signup Page (Model)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String getSignUpHomePage( Model model) {
		return "signup";
	}
	
	/**
	 * Return User's Home Page (Model) 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String getHomePage( Model model) {
		return "home";
	}
	
	/**
	 * Return Partials page (Model)
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "partials/{page}", method = RequestMethod.GET)
	public String getPage(Model model, @PathVariable String page) {
		return page;
	}
	
}
