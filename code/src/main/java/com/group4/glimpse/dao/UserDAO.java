package com.group4.glimpse.dao;

import com.group4.glimpse.model.User;

public interface UserDAO {

	/**
	 * create a new user
	 * @param user
	 * @return
	 */
	public User create(User user);
	
	/**
	 * update a user
	 * @param user
	 * @return
	 */
	public User update(User user);
	

	/**
	 * get an user's email
	 * @param user
	 * @return
	 */
	public User readEmail(String email);
	
}
