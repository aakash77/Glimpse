package com.group4.glimpse.dao;

import java.util.List;

import com.group4.glimpse.model.Project;
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
	
	/**
	 * get projects of a user
	 * @param id
	 * @return
	 */
	public List<Project> getProjects(User user);
	
	public User getUser(long id);

	public List<User> getAllUsers();

	public User read(long id);
	
}
