package com.group4.glimpse.controller;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<List> sendInvitation(@RequestParam("sendTo") String[] sendTo,@RequestParam("currentUser") String user ,@RequestParam("projectId") long projectId ){
		
		Project project = projectService.read(projectId);
		List<String> responses = new ArrayList<>();

		for(String send:sendTo){
			
			User receiver = userService.readEmail(send);
			User currentUser = userService.readEmail(user);
			
			//Send invitation when receiver not part of team
			//TODO CHECK this, both are returning different references hence mail is getting sent in all the cases
			if(!project.getTeam().contains(receiver)){
					Invitations invitation = new Invitations();
					invitation.setProject(project);
					invitation.setReceiver(receiver);
					invitation.setSender(currentUser);
					invitation.setStatus("pending");
					invitation = invitationService.create(invitation);
			try{
					emailSender.sendMail(send, "InvitationToCollaborate", invitation.getInvitation_id(), projectId);	
					responses.add("Email Invitation sent to: " +send);

			}
			catch(Exception e){
				responses.add("Email Invitation could not be sent to: " +send);
				}
			}
			else
				responses.add(" Invitation already sent to: " +send);

		}
		return new ResponseEntity<List>(responses, HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/invitation/accept" ,  method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> acceptInvitation(@RequestParam("invitationId") long invitationId ){
			//TODO Make a entry in team table	
			Invitations invitation = invitationService.read(invitationId);
			Project project = invitation.getProject();			
			User receiver = invitation.getReceiver();
			
			// If user is already part of team the request will be ignored
			if(!project.getTeam().contains(receiver)){
			project.getTeam().add(receiver);
			projectService.update(project);
			invitation.setStatus("Accepted");
			invitationService.update(invitation);	
			return new ResponseEntity<String>("Invitation Accepted ! ", HttpStatus.OK);	

			}
			
			return new ResponseEntity<String>("You are already the part of team ! ", HttpStatus.OK);	


	
	}
	
}
