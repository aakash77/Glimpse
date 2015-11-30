package com.group4.glimpse.service;

import com.group4.glimpse.model.Invitations;
import com.group4.glimpse.model.Project;

public interface InvitationService {

	/**
	 * create Invitation
	 */
	public Invitations create(Invitations invitations);
	
	/**
	 * update Invitation
	 */
	public Invitations update(Invitations invitations);
	
	/**
	 * delete Invitation
	 */
	public Invitations delete(long invitation_id);

	/**
	 * read Invitation
	 */
	public Invitations read(long invitation_id);
}
