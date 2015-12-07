package com.group4.glimpse.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.group4.glimpse.exception.BadRequestException;
import com.group4.glimpse.model.User;

/**
 * @author Group 4
 * InvitationLogging Aspect to interrupt send and accept invitations(throw BadRequest Exception)
 */
@Component
@Aspect
public class InvitationLoggingAspect {

	// POINTCUTS

	/**
	 Pointcut for sending an email invitation
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.InvitationController.sendInvitation(..))")
	public void sendInvitation() {}

	/**
	 Pointcut for accepting an email invitation
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.InvitationController.acceptInvitation(..))")
	public void acceptInvitation() {}

	// ADVICES

	/**
	 @Before Advice for sending an email invitation
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("sendInvitation()")
	public void sendInvitationBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Send Email Invitation request");
		Object args[] = joinPoint.getArgs();
		try{
			String[] sendTo = (String[]) args[0];				// get the email's list
			String user_email = (String) args[1];				// get the sender's email
			Long projectId = (Long) args[2]; 
			
			if(sendTo.length==0 || user_email==null || user_email=="" || projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid parameters.. Cann't be null.."); 
		}
	}

	/**
	 * @AfterReturning Advice after sending invitations
	 * @param joinPoint
	 * @param response
	 */
	@AfterReturning(pointcut="sendInvitation()",returning = "response")
	public void sendInvitationAfterAdvice(JoinPoint joinPoint,ResponseEntity<List> response) {
		System.out.println("The mail invitations are successfully send to the provided emails list.");
	}
	
	/**
	 @Before Advice for accepting an email invitation
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("acceptInvitation()")
	public void acceptInvitationBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Accept Email Invitation request");
	}

}
