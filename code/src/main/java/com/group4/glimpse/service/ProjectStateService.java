/**
 * 
 */
package com.group4.glimpse.service;

import com.group4.glimpse.model.Project_State;

/**
 * @author Glimpse
 *
 */
public interface ProjectStateService {
	
	/**
	 * @param projectState
	 * @return Project State
	 */
	public Project_State read(String project_state);
}