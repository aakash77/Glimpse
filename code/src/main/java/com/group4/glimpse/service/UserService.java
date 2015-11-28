package com.group4.glimpse.service;

import com.group4.glimpse.model.User;


public interface UserService {

	/**
	 * create a new user
	 * @param user
	 * @return
	 */
	public User create(User user);
	
	/**
	 * create/signin user bu google auth
	 * @param user
	 * @return
	 */
	public User createByAuth(User user);
	
	/**
	 * get a user
	 * @param user
	 * @return
	 */
	public User getUser(User user);
	
	/**
	 * get an user's email
	 * @param user
	 * @return
	 */
	public User readEmail(String email);
	
}