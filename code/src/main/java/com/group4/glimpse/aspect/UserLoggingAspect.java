package com.group4.glimpse.aspect;

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
 * UserLoggingAspect to validate the requests and authorize them or unauthorize them (throw BadRequest Exception)
 */
@Component
@Aspect
public class UserLoggingAspect {

	// POINTCUTS

	/**
	 Pointcut for adding a user
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.addUser(..))")
	public void addUser() {}

	/**
	 Pointcut for getting all users
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.getAllUsers(..))")
	public void getAllUsers() {}

	/**
	 Pointcut for getting a user
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.getUser(..))")
	public void getUser() {}

	/**
	 Pointcut for validating an email
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.validateEmail(..))")
	public void validateEmail() {}

	/**
	 Pointcut for adding user by google oauth
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.addUserByAuth(..))")
	public void addUserByAuth() {}

	/**
	 Pointcut for checking if an email is unique
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.checkUniqueEmail(..))")
	public void checkUniqueEmail() {}

	/**
	 Pointcut for checking if an email is unique
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.UserController.getProjects(..))")
	public void getProjects() {}

	// ADVICES

	/**
	 @Before Advice validating the parameters before adding the user
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("addUser()")
	public void addUserBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Add user request");
		Object args[] = joinPoint.getArgs();
		try{
			User user = (User) args[0];				// get the user details
			if(user.getName()==null || user.getName()=="" || user.getEmail()==null || user.getEmail()=="" || user.getPassword()==null || user.getPassword()=="")
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid User parameters.. Cann't be null.."); 
		}
	}

	/**
	 * @AfterReturning Advice after adding a user
	 * @param joinPoint
	 * @param response
	 */
	@AfterReturning(pointcut="addUser()",returning = "response")
	public void addUserAfterAdvice(JoinPoint joinPoint,ResponseEntity<String> response) {
		System.out.println("An mail invitation has been send to the user's email id");
		System.out.println("Method returned value is : " + response);
	}

	/**
	 * @Before Advice to get all users of the project Glimpse
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getAllUsers()")
	public void getAllUsersBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Get all users request");
	}

	/**
	 * @Before Advice to get a user
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getUser()")
	public void getUserBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Get user request");
	}

	/**
	 * @Before Advice to get a user
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("validateEmail()")
	public void validateEmailBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Validate email request");
	}

	/**
	 @Before Advice validating the parameters before adding the user by Google OAuth
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("addUserByAuth()")
	public void addUserByAuthBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Add user by Auth request");
		Object args[] = joinPoint.getArgs();
		try{
			User user = (User) args[0];				// get the user details
			if(user.getName()==null || user.getName()=="" || user.getEmail()==null || user.getEmail()=="")
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid User parameters.. Cann't be null.."); 
		}
	}
	
	/**
	 * @AfterReturning Advice after adding a user by Google OAuth
	 * @param joinPoint
	 * @param response
	 */
	@AfterReturning(pointcut="addUserByAuth()",returning = "response")
	public void addUserByAuthAfterAdvice(JoinPoint joinPoint,ResponseEntity<String> response) {
		System.out.println("An mail invitation has been send to the user's email id");
		System.out.println("Method returned value is : " + response);
	}

	/**
	 * @Before Advice to get a user
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("checkUniqueEmail()")
	public void checkUniqueEmailBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Unique email check request");
	}

	/**
	 * @Before Advice to get all projects for a user
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getProjects()")
	public void getProjectsEmailBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{
		System.out.println("Get Projects for a User request");
	}

}
