package com.group4.glimpse.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {

	/**
	 * This method will compose and send the message for invitation to be a part of a project/team
	 * @param to
	 * @param subject
	 * @param invitationId
	 * @param project_id
	 */
	public void sendMail(String to, String subject, long invitationId, long project_id);

	/**
	 * This method will compose and send the message for email validation
	 * @param to
	 * @param subject
	 * @param idEmailValidation
	 */
	public void sendMail(String to, String subject, long idEmailValidation);

}