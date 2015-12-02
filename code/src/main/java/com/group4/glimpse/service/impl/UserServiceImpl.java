package com.group4.glimpse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.UserDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.User;
import com.group4.glimpse.service.UserService;
import com.group4.glimpse.util.PasswordHash;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	PasswordHash passwordHash;

	/**
	 * Service Implementation of creating a new User
	 */
	public User create(User user) {
		//String hashed_password = passwordHash.hashPassword(user.getPassword());
		//user.setPassword(hashed_password);
		return userDAO.create(user);
	}

	/**
	 * Service Implementation to get a User by email
	 */
	public User readEmail(String email) {
		return userDAO.readEmail(email);
	}
	
	public User update(User user) {
		return userDAO.update(user);
	}

	/**
	 * Service Implementation to get a user
	 */
	public User getUser(User user){
		User valid_user = userDAO.readEmail(user.getEmail());

		System.out.println(valid_user.getPassword());

		if(valid_user!=null){
			if(!(passwordHash.checkPassword(user.getPassword(),valid_user.getPassword())))
				return null;
		}
		return valid_user;
	}

	/**
	 * Service Implementation of creating/sign in user by google auth
	 */
	public User createByAuth(User user) {
		User u = userDAO.readEmail(user.getEmail());
		if(u==null)
			return userDAO.create(user);
		else{
			user.setId(u.getId());
			return userDAO.update(user);
		}
	}
	
	/**
	 * Service Implementation to get projects of an user
	 */
	@Override
	public List<Project> getProjects(long id) {
		
		User user = userDAO.getUser(id);
		return userDAO.getProjects(user);
	}

	@Override
	public List<User> getAllUsers() {
	
		return userDAO.getAllUsers();
	}


}
