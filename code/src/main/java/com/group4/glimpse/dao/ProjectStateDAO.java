package com.group4.glimpse.dao;

import com.group4.glimpse.model.Project_State;

public interface ProjectStateDAO {
	/**
	 * read project state
	 * @param project_state
	 * @return
	 */
	public Project_State read(String project_state);
}
