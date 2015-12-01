package com.group4.glimpse.controller;

import java.util.List;

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
import com.group4.glimpse.model.Project_State;
import com.group4.glimpse.model.Task;
import com.group4.glimpse.model.User;
import com.group4.glimpse.service.ProjectService;

@Controller
@RequestMapping(value="/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Project> addProject(@ModelAttribute Project project,
			@ModelAttribute User user,
			@ModelAttribute Project_State state){	
					
			Project_State state_planning =  new Project_State();
			state_planning.setProject_state_id(1);
		
			//When a project is just created, its status is planning.
			if(project.getState()==null){
			project.setState(state_planning);
			}
			
			//TODO: Set current user as the owner
			project.setOwner(user);
			
			project.getTeam().add(user);
			
			project = projectService.create(project);
					
			return new ResponseEntity<Project>(project, HttpStatus.OK);	
	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	@ResponseBody
	public ResponseEntity<Project> getProject(@PathVariable long id,
			@RequestParam(required=false) String format){
		
		Project project = projectService.read(id);
		if(project==null)
			return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	@ResponseBody
	public ResponseEntity<Project> deleteProject(@PathVariable long id){

		Project project = projectService.delete(id);
		if(project==null)
			return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="{id}")
	@ResponseBody
	public ResponseEntity<Project> updateProject(@PathVariable long id,
			@ModelAttribute Project project,
			@ModelAttribute Project_State projectstate){
		 
		Project projectUpdate = projectService.read(id);
		
		if(project.getDescription()!=null){
		projectUpdate.setDescription(project.getDescription());
		}
		
		if(projectstate!=null){
			projectUpdate.setState(projectstate);
			}
		
		if(project.getTitle()!=null){
			projectUpdate.setTitle(project.getTitle());
			}
		
		//TODO add checks to update
		project = projectService.update(projectUpdate);
		if(project==null)
		return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{project_id}/tasks",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List> getAllUsers(@PathVariable long project_id){
		System.err.println(project_id);
		List<Task> tasks = projectService.getAllTasks(project_id);
		return new ResponseEntity<List>(tasks, HttpStatus.OK);
	}

}
