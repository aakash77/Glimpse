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
import com.group4.glimpse.service.TaskService;

@Controller
@RequestMapping(value="/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Task> addUser(@ModelAttribute Task task,
			@ModelAttribute User assignee,
			@ModelAttribute Task_State state, 
			@ModelAttribute Project project){	
			
			task.setProject(project);
			task.setState(state);
			task.setAssignee(assignee);
		
			task = taskService.create(task);		
			return new ResponseEntity<Task>(task, HttpStatus.OK);	
	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	@ResponseBody
	public ResponseEntity<Task> getPerson(@PathVariable long id,
			@RequestParam(required=false) String format){
		
		Task task = taskService.read(id);
		if(task==null)
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	@ResponseBody
	public ResponseEntity<Task> deletePerson(@PathVariable long id){

		Task task = taskService.delete(id);
		if(task==null)
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="{id}")
	@ResponseBody
	public ResponseEntity<Task> updatePerson(@PathVariable long id,
			@ModelAttribute Task task,
			@ModelAttribute User assignee,
			@ModelAttribute Task_State task_state){

		//TODO add checks to update
		Task taskUpdate = taskService.read(id);
		
		if(task.getActual()!=0){
			taskUpdate.setActual(task.getActual());
		}
		if(task.getEstimate()!=0){
			taskUpdate.setEstimate(task.getEstimate());
		}
		if(task.getDescription()!=null){
			taskUpdate.setDescription(task.getDescription());
		}
		if(task.getTitle()!=null){
			taskUpdate.setTitle(task.getTitle());
		}
		if(task_state!=null){
			taskUpdate.setState(task_state);
		}
		if(assignee!=null){
			taskUpdate.setAssignee(assignee);
		}
	
		task = taskService.update(taskUpdate);
		if(task==null)
		return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

}
