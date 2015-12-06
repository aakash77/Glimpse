package com.group4.glimpse.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {

	/**
	 * This method will compose and send the message
	 * */

	public void sendMail(String to, String subject, long invitationId, long project_id);
	

	public void sendMail(String to, String subject, long idEmailValidation);
	
}