package com.group4.glimpse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Table(name="task_state")
public class Task_State {

	@Id
    @Column(name="task_state_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long task_state_id;
	
	@Column(name="value",unique=true)
	private String value;

	/**
	 * @return the task_state_id
	 */
	public long getTask_state_id() {
		return task_state_id;
	}

	/**
	 * @param task_state_id the task_state_id to set
	 */
	public void setTask_state_id(long task_state_id) {
		this.task_state_id = task_state_id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}