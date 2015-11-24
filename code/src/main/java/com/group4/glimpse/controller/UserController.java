package com.group4.glimpse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.glimpse.model.User;
import com.group4.glimpse.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> getUser(@ModelAttribute User user){
		
		User valid_user = userService.readEmail(user.getEmail());
		if(valid_user==null)
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);		

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(user.getPassword(), valid_user.getPassword()))
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = "/api/signup",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> addUser(@ModelAttribute User user){
		
		System.out.println("in signup api");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		
		user = userService.create(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	@RequestMapping(value = "/api/users",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> checkUniqueEmail(@ModelAttribute String email){
		
		System.out.println("in api users");
		
		User user = userService.readEmail(email);
		if(user==null)
			return new ResponseEntity<String>("{ \"available\": true}", HttpStatus.OK);
		else
			return new ResponseEntity<String>("{ \"available\": false}", HttpStatus.BAD_REQUEST);
	}	
}
