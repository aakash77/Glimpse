package com.group4.glimpse.service;

import com.group4.glimpse.model.Task;

public interface TaskService {
	/**
	 * create Task
	 */
	public Task create(Task task);
	
	/**
	 * update Task
	 */
	public Task update(Task task);
	
	
	/**
	 * delete Task
	 */
	public Task delete(long task_id);

	/**
	 * read Task
	 */
	public Task read(long task_id);
}
