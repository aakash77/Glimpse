package com.group4.glimpse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Table(name="task")
public class Task {

	@Id
    @Column(name="task_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long task_id;

	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToOne
	@JoinColumn(name="assignee",referencedColumnName="id")
	private User assignee;
	
	@OneToOne
	@JoinColumn(name="state",referencedColumnName="task_state_id")
	private Task_State state;
		
	@Column(name="estimate")
	private int estimate;
	
	@Column(name="actual")
	private int actual;

	/**
	 * @return the task_id
	 */
	public long getTask_id() {
		return task_id;
	}

	/**
	 * @param task_id the task_id to set
	 */
	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the assignee
	 */
	public User getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	/**
	 * @return the state
	 */
	public Task_State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Task_State state) {
		this.state = state;
	}

	/**
	 * @return the estimate
	 */
	public int getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	/**
	 * @return the actual
	 */
	public int getActual() {
		return actual;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(int actual) {
		this.actual = actual;
	}
		
}
