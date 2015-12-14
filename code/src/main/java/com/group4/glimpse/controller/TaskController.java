 package com.group4.glimpse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;
import com.group4.glimpse.model.Task_State;
import com.group4.glimpse.model.User;
import com.group4.glimpse.service.ProjectService;
import com.group4.glimpse.service.TaskService;

/**
 * @author Group 4
 * Task controller
 */

@Controller
@RequestMapping(value="/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ProjectService projectService;
	
	/**
	 * Adding a new task
	 * @param task
	 * @param assignee
	 * @param state
	 * @param project
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Task> addTask(@ModelAttribute Task task,
			@ModelAttribute User assignee,
			@ModelAttribute Task_State state, 
			@ModelAttribute Project project){	
		
		
			//Only during the planning or ongoing stage, tasks can be added to or deleted from the project.
			Project projectDetails = projectService.read(project.getProject_id());
			
			if(projectDetails.getState().getProject_state_id()!=1 && projectDetails.getState().getProject_state_id()!=2){
				return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
			}
			
			task.setProject(project);
			task.setState(state);
			task.setAssignee(assignee);
			
			//TODO: represent estimated units of work (provided when planning a task) 
	
			
			//actual units of work (provided when marking a task as finished). 
			if(task.getState().getTask_state_id()!=4){
				task.setActual(0);
			}
				
			//TODO
			//Any participant of the project, including the owner, can add tasks to a project.
			//Current user should be a project participant.
			// Team table should return a row for combination of project.getProject_id() and current_user_id
		
			
			task = taskService.create(task);		
			return new ResponseEntity<Task>(task, HttpStatus.OK);	
	
	}
	
	/**
	 * Get a task
	 * @param id
	 * @param format
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	@ResponseBody
	public ResponseEntity<Task> getTask(@PathVariable long id,
			@RequestParam(required=false) String format){
		
		Task task = taskService.read(id);
		if(task==null)
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	/**
	 * Delete a task
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	@ResponseBody
	public ResponseEntity<Task> deleteTask(@PathVariable long id){

		//Only during the planning stage, tasks can be deleted from the project
		Task task = taskService.read(id);

		if(task.getProject().getState().getProject_state_id()!=1)
		{			
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
			
		}
		task = taskService.delete(id);
		if(task==null)
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	/**
	 * Update a task
	 * @param id
	 * @param task
	 * @param assignee
	 * @param task_state
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="{task_id}")
	@ResponseBody
	public ResponseEntity<Task> updateTask(@PathVariable long task_id,
			@ModelAttribute Task task,
			@ModelAttribute User assignee,
			@ModelAttribute Task_State task_state,
			@ModelAttribute Project project){

		
		//TODO add checks to update
		Task taskUpdate = taskService.read(task_id);
		
		if(task.getActual()!=0){
			taskUpdate.setActual(task.getActual());
		}
		
		//Estimate only when task is in finished state else assign 0
		if(task.getEstimate()!=0){
			if(task_state.getTask_state_id()==4 || taskUpdate.getState().getTask_state_id()==4){
			taskUpdate.setEstimate(task.getEstimate());
			}	
		}
		
		if(task.getDescription()!=null){
			taskUpdate.setDescription(task.getDescription());
		}
		if(task.getTitle()!=null){
			taskUpdate.setTitle(task.getTitle());
		}
		if(task_state!=null){
			if(task_state.getTask_state_id()==5){
				//Only the owner of the project can cancel a task.  
				//current user_id = task.getProject().getOwner().getId();
				taskUpdate.setState(task_state);
			}
			else{
			taskUpdate.setState(task_state);
			}
		}
		if(assignee.getId()!=0){
			taskUpdate.setAssignee(assignee);
		}
	
		task = taskService.update(taskUpdate);
		if(task==null)
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
}