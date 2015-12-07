package com.group4.glimpse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.group4.glimpse.exception.BadRequestException;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;

/**
 * @author Group 4
 * TaskLoggingAspect to validate the requests for task api's (throw BadRequest Exception)
 */
@Component
@Aspect
public class TaskLoggingAspect {

	// POINTCUTS

	/**
	 Pointcut for adding a task
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.TaskController.addTask(..))")
	public void addTask() {}

	/**
	 Pointcut for getting a task
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.TaskController.getTask(..))")
	public void getTask() {}

	/**
	 Pointcut for deleting a task
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.TaskController.deleteTask(..))")
	public void deleteTask() {}

	/**
	 Pointcut for updating a task
	 */
	@Pointcut("execution(* com.group4.glimpse.controller.TaskController.updateTask(..))")
	public void updateTask() {}

	// ADVICES

	/**
	 @Before Advice validating the parameters before adding a task
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("addTask()")
	public void addTaskBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Add task request");
		Object args[] = joinPoint.getArgs();
		try{
			Task task = (Task) args[0];				// get the task details
			Integer estimate = (Integer) task.getEstimate();
			Project project = (Project) args[3];
			Long projectId = (Long) project.getProject_id();

			if(task.getTitle()==null ||task.getTitle()=="" || task.getDescription()==null || task.getDescription()=="" || estimate==null || projectId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Task parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before getting a task
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("getTask()")
	public void getTaskBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Get task request");
		Object args[] = joinPoint.getArgs();
		try{
			Long taskId = (Long) args[0];				// get the task id

			if(taskId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Get Task parameters.. Cann't be null.."); 
		}	
	}

	/**
	 @Before Advice validating the parameters before deleting a task
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("deleteTask()")
	public void deleteTaskBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Delete task request");
		Object args[] = joinPoint.getArgs();
		try{
			Long taskId = (Long) args[0];				// get the task id
			
			if(taskId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Delete Task parameters.. Cann't be null.."); 
		}
	}

	/**
	 @Before Advice validating the parameters before updating a task
	 * @param joinPoint
	 * @throws BadRequestException
	 */
	@Before("updateTask()")
	public void updateProjectBeforeAdvice(JoinPoint joinPoint) throws BadRequestException{

		System.out.println("Update task request");
		Object args[] = joinPoint.getArgs();
		try{
			Long taskId = (Long) args[0];				// get the task id
			
			if(taskId==null)
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			throw new BadRequestException("Invalid Update Task parameters.. Cann't be null.."); 
		}
	}
	
}
