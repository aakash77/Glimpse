package com.group4.glimpse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Project_State;
import com.group4.glimpse.model.Task;
import com.group4.glimpse.service.ProjectService;
import com.group4.glimpse.service.ProjectStateService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	ProjectStateService projectStateService;

	/**
	 * Service Implementation to create a new project
	 */
	public Project create(Project project) {
		return projectDAO.create(project);
	}

	/**
	 * Service Implementation to read/get a project
	 */
	public Project read(long id) {
		return projectDAO.read(id);
	}

	/**
	 * Service Implementation to update a project
	 */
	public Project update(Project project) {
		return projectDAO.update(project);
	}
	
	/**
	 * Delete a project
	 */
	public Project delete(long id) {
		Project project = projectDAO.read(id);
		if(project==null){
			return null;
		}
		else{
			Project_State project_State = projectStateService.read("cancelled");
			project.setState(project_State);
			return projectDAO.update(project);
		}
	}
	
	/**
	 * Get all Tasks of a project
	 */
	@Override
	public List<Task> getAllTasks(long project_id) {
		return projectDAO.getAllTasks(project_id);
	}
	
	/**
	 * Update Project State
	 */
	@Override
	public Project updateState(long project_id, String state_value) {
		Project project = projectDAO.read(project_id);
		if(project==null)
			return null;
		Project_State project_State = projectStateService.read(state_value);
		if(project_State==null)
			return null;
		project.setState(project_State);
		return projectDAO.update(project);
	}
}