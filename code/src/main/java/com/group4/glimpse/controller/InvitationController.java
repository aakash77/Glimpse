package com.group4.glimpse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.glimpse.model.Invitations;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.User;
import com.group4.glimpse.service.EmailSender;
import com.group4.glimpse.service.InvitationService;
import com.group4.glimpse.service.ProjectService;
import com.group4.glimpse.service.UserService;

@Controller
public class InvitationController {
	@Autowired
	EmailSender emailSender;
	
	@Autowired
	InvitationService invitationService;

	@Autowired
	ProjectService projectService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/invitation/send", method=RequestMethod.POST)
	@ResponseBody
//	public ResponseEntity<String> sendInvitation(@RequestParam("sendTo") String sendTo, @RequestParam("projectId") long projectId ){
	public ResponseEntity<String> sendInvitation(@RequestParam("sendTo") String[] sendTo,@RequestParam("currentUser") String user ,@RequestParam("projectId") long projectId ){
		
		Project project = projectService.read(projectId);

		for(String send:sendTo){
		User receiver = userService.readEmail(send);
		Invitations invitation = new Invitations();
		invitation.setProject(project);
		invitation.setReceiver(receiver);
		
		User currentUser = userService.readEmail(user);
		invitation.setSender(currentUser);
		
		invitation.setStatus("pending");
		invitation = invitationService.create(invitation);
		
		emailSender.sendMail(send, "InvitationToCollaborate", invitation.getInvitation_id(), projectId);		
		}
		return new ResponseEntity<String>("Invitation Sent ! ", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/invitation/accept" ,  method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> acceptInvitation(@RequestParam("invitationId") long invitationId ){
			//TODO Make a entry in team table	
			Invitations invitation = invitationService.read(invitationId);
			Project project = invitation.getProject();			
			User receiver = invitation.getReceiver();
			User sender = invitation.getSender();
			project.getTeam().add(receiver);
			projectService.update(project);
			
			invitation.setStatus("Accepted");
			invitationService.update(invitation);
			
			return new ResponseEntity<String>("Invitation Accepted ! ", HttpStatus.OK);	
	}
	
}
