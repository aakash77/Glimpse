package com.group4.glimpse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.dao.TaskDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;
import com.group4.glimpse.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskDAO;

	/**
	 * Service Implementation to create a new task
	 */
	public Task create(Task task) {
		return taskDAO.create(task);
	}

	/**
	 * Service Implementation to read/get a task
	 */
	public Task read(long id) {
		return taskDAO.read(id);
	}

	/**
	 * Service Implementation to update a task
	 */
	public Task update(Task task) {
		return taskDAO.update(task);
	}

	/**
	 * Service Implementation to delete a task
	 */
	public Task delete(long id) {
		Task task = taskDAO.read(id);
		if(task==null){
			return null;
		}
		else{
			return taskDAO.delete(task);
		}
	}
}
