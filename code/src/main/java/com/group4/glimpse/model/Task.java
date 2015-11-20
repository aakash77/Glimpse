package com.group4.glimpse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	
	private User assignee;
	
	public enum state {
		New, Assigned, Started, Finished, Cancelled 
	}
	
	@Column(name="estimate")
	private int estimate;
	
	@Column(name="actual")
	private int actual;
	
	
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
