package com.group4.glimpse.dao;

import com.group4.glimpse.model.Invitations;
import com.group4.glimpse.model.Project;

public interface InvitationDAO {
	/**
	 * create a new project entry
	 * @return the project created or appropriate error code 
	 */
	public Invitations create(Invitations invitations);
	
	/**
	 * read details of a Project
	 * @return
	 */
	public Invitations read(long invitation_id);
	
	
	/**
	 * update project's details
	 * @return details of the Project updated or appropriate error code
	 */
	public Invitations update(Invitations invitations);
	
	/**
	 * delete project entry
	 * @return deleted entry of project
	 */
	public Invitations delete(Invitations invitations);
}
