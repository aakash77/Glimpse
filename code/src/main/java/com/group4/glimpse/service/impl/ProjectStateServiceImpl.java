package com.group4.glimpse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectStateDAO;
import com.group4.glimpse.model.Project_State;
import com.group4.glimpse.service.ProjectStateService;

@Service
@Transactional
public class ProjectStateServiceImpl implements ProjectStateService {

	@Autowired
	ProjectStateDAO projectStateDAO;
	
	@Override
	public Project_State read(String project_state) {
		return projectStateDAO.read(project_state);
	}
}