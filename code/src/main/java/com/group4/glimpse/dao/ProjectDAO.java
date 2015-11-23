package com.group4.glimpse.dao;

import com.group4.glimpse.model.Project;


public interface ProjectDAO {

	/**
	 * create a new person entry
	 * @return the person created or appropriate error code 
	 */
	public Project create(Project project);
	
	/**
	 * read person's details 
	 * @return details of the Person read or appropriate error code
	 */
	public Project read(long project_id);
	
	
	/**
	 * update person's details
	 * @return details of the Person updated or appropriate error code
	 */
	public Project update(Project project);
	
	/**
	 * delete person entry
	 * @return deleted entry of person
	 */
	public Project delete(Project project);
}
