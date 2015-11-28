package com.group4.glimpse.dao;

import com.group4.glimpse.model.Project;


public interface ProjectDAO {

	/**
	 * create a new project entry
	 * @return the project created or appropriate error code 
	 */
	public Project create(Project project);
	
	/**
	 * read details of a Project
	 * @return
	 */
	public Project read(long project_id);
	
	
	/**
	 * update project's details
	 * @return details of the Project updated or appropriate error code
	 */
	public Project update(Project project);
	
	/**
	 * delete project entry
	 * @return deleted entry of project
	 */
	public Project delete(Project project);
}
