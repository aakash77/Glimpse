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

@Entity
@Table(name="Invitations")
public class Invitations {

	@Id
    @Column(name="invitation_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long invitation_id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name="sender",referencedColumnName="id")
	private User sender;

	@OneToOne
	@JoinColumn(name="receiver",referencedColumnName="id")
	private User receiver;

	@Column(name="status")
	private String status = "pending";

	/**
	 * @return the invitation_id
	 */
	public long getInvitation_id() {
		return invitation_id;
	}

	/**
	 * @param invitation_id the invitation_id to set
	 */
	public void setInvitation_id(long invitation_id) {
		this.invitation_id = invitation_id;
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
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
