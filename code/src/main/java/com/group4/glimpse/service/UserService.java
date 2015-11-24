package com.group4.glimpse.service;

import com.group4.glimpse.model.User;


public interface UserService {

	/**
	 * create a new user
	 */
	public User create(User user);
	
	/**
	 * get an user's email
	 * @param user
	 * @return
	 */
	public User readEmail(String email);
	
}