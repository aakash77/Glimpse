package com.group4.glimpse.service;

import com.group4.glimpse.model.Project;

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
}
