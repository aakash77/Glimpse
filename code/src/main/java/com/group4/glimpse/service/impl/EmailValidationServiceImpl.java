package com.group4.glimpse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.UserValidationDAO;
import com.group4.glimpse.model.EmailValidation;
import com.group4.glimpse.service.EmailValidationService;
import com.group4.glimpse.util.PasswordHash;

@Service
@Transactional
public class EmailValidationServiceImpl implements EmailValidationService {

	@Autowired
	UserValidationDAO userValidationDAO;

	PasswordHash passwordHash;

	/**
	 * Service Implementation of creating a new User
	 */
	public EmailValidation create(EmailValidation user) {
		String hashed_password = passwordHash.hashPassword(user.getPassword());
		user.setPassword(hashed_password);
		return userValidationDAO.create(user);
	}
	
	public EmailValidation update(EmailValidation user) {
		return userValidationDAO.update(user);

	}

	@Override
	public EmailValidation read(long invitationid) {
		return userValidationDAO.read(invitationid);

	}


}
