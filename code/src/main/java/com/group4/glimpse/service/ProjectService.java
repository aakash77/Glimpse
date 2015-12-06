package com.group4.glimpse.service;

import java.util.List;

import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;

public interface ProjectService {

	/**
	 * create Project
	 */
	public Project create(Project project);
	
	/**
	 * update Project
	 */
	public Project update(Project project);
	
	/**
	 * delete Project
	 */
	public Project delete(long project_id);

	/**
	 * read Project
	 */
	public Project read(long project_id);
	
	/**
	 * get all tasks
	 */
	public List<Task> getAllTasks(long project_id);
	
	
	public Project updateState(long project_id,String state_value);
}
