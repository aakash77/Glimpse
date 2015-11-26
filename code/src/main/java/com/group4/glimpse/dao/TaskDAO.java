package com.group4.glimpse.dao;

import com.group4.glimpse.model.Task;

public interface TaskDAO {
	/**
	 * create a new task entry
	 * @return the task created or appropriate error code 
	 */
	public Task create(Task task);
	
	/**
	 * read details of a Task
	 * @return
	 */
	public Task read(long task_id);
	
	
	/**
	 * update task's details
	 * @return details of the Task updated or appropriate error code
	 */
	public Task update(Task task);
	
	/**
	 * delete task entry
	 * @return deleted entry of task
	 */
	public Task delete(Task task);
}
