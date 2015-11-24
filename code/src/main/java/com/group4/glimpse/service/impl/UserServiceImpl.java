package com.group4.glimpse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.UserDAO;
import com.group4.glimpse.model.User;
import com.group4.glimpse.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	/**
	 * Service Implementation of creating a new User
	 */
	public User create(User user) {
		return userDAO.create(user);
	}

	public User readEmail(String email) {
		return userDAO.readEmail(email);
	}


}
