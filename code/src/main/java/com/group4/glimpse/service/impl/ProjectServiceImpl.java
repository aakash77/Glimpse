package com.group4.glimpse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;
import com.group4.glimpse.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO projectDAO;
	
	public Project create(Project project) {
		return projectDAO.create(project);
	}

	public Project read(long id) {
		return projectDAO.read(id);
	}

	public Project update(Project project) {
		return projectDAO.update(project);
	}

	public Project delete(long id) {
		Project project = projectDAO.read(id);
		if(project==null){
			return null;
		}
		else{
			return projectDAO.delete(project);
		}
	}

	@Override
	public List<Task> getAllTasks(long project_id) {
		return projectDAO.getAllTasks(project_id);
	}


}
