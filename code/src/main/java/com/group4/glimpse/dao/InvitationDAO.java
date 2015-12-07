package com.group4.glimpse.dao;

import com.group4.glimpse.model.Invitations;
import com.group4.glimpse.model.Project;

public interface InvitationDAO {
	/**
	 * create a new invitation
	 * @return the invitation created
	 */
	public Invitations create(Invitations invitations);
	
	/**
	 * read details of a invitation
	 * @return
	 */
	public Invitations read(long invitation_id);
	
	
	/**
	 * update invitation's details
	 * @return details of the Invitation updated or appropriate error code
	 */
	public Invitations update(Invitations invitations);
	
	/**
	 * delete invitation entry
	 * @return deleted entry of invitation
	 */
	public Invitations delete(Invitations invitations);
}
