package com.group4.glimpse.service;

import com.group4.glimpse.model.EmailValidation;
import com.group4.glimpse.model.User;

public interface EmailValidationService {
	/**
	 * create a new user
	 * @param user
	 * @return
	 */
	public EmailValidation create(EmailValidation user);
	
	/**
	 * Update the User 
	 * @param user
	 * @return
	 */
	
	public EmailValidation update(EmailValidation user);
	
	/**
	 * Read the User 
	 * @param user
	 * @return
	 */
	
	public EmailValidation read(long invitationid);

	public EmailValidation readEmail(String email);


}
