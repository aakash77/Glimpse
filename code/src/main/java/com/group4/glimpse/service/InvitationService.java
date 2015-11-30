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
	public Invitations delete(long project_id);

	/**
	 * read Invitation
	 */
	public Invitations read(long project_id);
}
