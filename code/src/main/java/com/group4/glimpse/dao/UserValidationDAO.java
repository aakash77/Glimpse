package com.group4.glimpse.dao;

import com.group4.glimpse.model.EmailValidation;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.User;

public interface UserValidationDAO {
	/**
	 * create a new user
	 * @param user
	 * @return
	 */
	public EmailValidation create(EmailValidation user);
	
	/**
	 * update a user
	 * @param user
	 * @return
	 */
	public EmailValidation update(EmailValidation user);
	

	/**
	 * read details of a user
	 * @return
	 */
	public EmailValidation read(long idEmailValidation);
	
	public EmailValidation readEmail(String email);



}
