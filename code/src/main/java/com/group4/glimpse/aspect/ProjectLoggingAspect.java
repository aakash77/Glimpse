package com.group4.glimpse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.group4.glimpse.exception.BadRequestException;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Project_State;
import com.group4.glimpse.model.User;

/**
 * @author Group 4
 * ProjectLoggingAspect to validate the requests for project api's (throw BadRequest Exception)
 */

@Component
@Aspect
public class ProjectLoggingAspect {
	
	// POINTCUTS

	/**
	 Pointcut for adding a project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.addProject(..))")
	public void addProject() {}

	/**
	 Pointcut for getting a project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.getProject(..))")
	public void getProject() {}

	/**
	 Pointcut for deleting/removing a project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.deleteProject(..))")
	public void deleteProject() {}
	
	/**
	 Pointcut for updating a project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.updateProject(..))")
	public void updateProject() {}

	/**
	 Pointcut for getting all the tasks for a project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.getAllTasks(..))")
	public void getAllTasks() {}
	
	/**
	 Pointcut for updating the state of project
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.ProjectController.updateState(..))")
	public void updateState() {}
	
	// ADVICES

	/**
	 @Before Advice validating the parameters before adding a project
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("addProject()")
	public void addProjectBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Add project request");
		Object args[] = joinPoint.getArgs();
		try{
			String title = (String) args[0];				// get the project details
			String description = (String) args[1];
			String user_id = (String) args[2];
			
			if(title==null ||title=="" || description==null || description=="" || user_id==null || user_id=="")
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Project parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before getting a project
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getProject()")
	public void getProjectBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Get project request");
		Object args[] = joinPoint.getArgs();
		try{
			Long projectId = (Long) args[0];				// get the project id
			
			if(projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Get Project parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before deleting a project
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("deleteProject()")
	public void deleteProjectBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Delete project request");
		Object args[] = joinPoint.getArgs();
		try{
			Long projectId = (Long) args[0];				// get the project id
			
			if(projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Delete Project parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before updating a project
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("updateProject()")
	public void updateProjectBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Update project request");
		Object args[] = joinPoint.getArgs();
		try{
			Long projectId = (Long) args[0];				// get the project id
			
			if(projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Update Project parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before getting all the tasks
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getAllTasks()")
	public void getAllTasksBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Get tasks request");
		Object args[] = joinPoint.getArgs();
		try{
			Long projectId = (Long) args[0];				// get the project id
			
			if(projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Get Tasks parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before updating the state of project
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("updateState()")
	public void updateStateBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Update project State request");
		Object args[] = joinPoint.getArgs();
		try{
			Long projectId = (Long) args[0];				// get the project id
			String state_value = (String) args[1];
			
			if(projectId==null || state_value==null || state_value=="")
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Update Project State parameters.. Cann't be null.."); 
		}
	}
	
}
