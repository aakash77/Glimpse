package com.group4.glimpse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.InvitationDAO;
import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Invitations;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.service.InvitationService;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService {
	
	@Autowired
	InvitationDAO invitationDAO;
	
	@Override
	public Invitations create(Invitations invitations) {
		return invitationDAO.create(invitations);

	}

	@Override
	public Invitations update(Invitations invitations) {
		return invitationDAO.update(invitations);

	}

	@Override
	public Invitations delete(long invitation_id) {
		Invitations invitation = invitationDAO.read(invitation_id);

		if(invitation==null){
			return null;
		}
		else{
			return invitationDAO.delete(invitation);
		}
	}

	@Override
	public Invitations read(long invitation_id) {
		return invitationDAO.read(invitation_id);
	}

	

}
