package com.group4.glimpse.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.group4.glimpse.model.Project;

@Service
public class EmailSender {
	 
	    @Autowired
	    private MailSender mailSender;
	    
	    @Autowired
	    private ProjectService projectService;
	    	 
	    /**
	     * This method will compose and send the message
	     * */
	    
	    public void sendMail(String to, String subject, long invitationId, long project_id)
	    {
	    	Project project = projectService.read(project_id);
	    	
	        String messageBody = "This is an invitation to collaborate for the project " +
	    	                      project.getTitle() + "\n" + "This project is about " + project.getDescription() + "\n" +
	    	                      "To accept the invitation click on the below link" + "\n" 
	    	                      + "http:" + "/" + "/" + "localhost:8080" + "/" + "glimpse/invitation/accept" + "?"
	    	                      + "invitationId" + "=" + invitationId ;
	        
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(messageBody);
	        mailSender.send(message);
	        
	    }
	 
	    public void sendMail(String to, String subject, long idEmailValidation)
	    {

	    	String messageBody = "Please validate your email address for" +
	    			"To accept the invitation click on the below link" + "\n" 
	    			+ "http:" + "/" + "/" + "localhost:8080" + "/" + "glimpse/validate" + "?"
	    			+ "idEmailValidation" + "=" + idEmailValidation ;
	    	
	    	System.out.println("idEmailValidation"+idEmailValidation);

	    	System.out.println("messageBody"+messageBody);
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	message.setTo(to);
	    	message.setSubject(subject);
	    	message.setText(messageBody);
	    	mailSender.send(message);

	    }
}
