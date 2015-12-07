package com.group4.glimpse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Group 4 
 * Project POJO class
 */
@Entity
@Table(name="project")
public class Project {

	@Id
    @Column(name="project_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long project_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToOne
	@JoinColumn(name="owner", referencedColumnName = "id")
	private User owner;
	
	@OneToOne
	@JoinColumn(name="state", referencedColumnName = "project_state_id")
	private Project_State state;

	
	@ManyToMany(fetch = FetchType.EAGER)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinTable(name = "team", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user",referencedColumnName="id"))
	private List<User> team = new ArrayList<User>();
	

	/**
	 * @return the project_id
	 */
	public long getProject_id() {
		return project_id;
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(long project_id) {
		this.project_id = project_id;
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
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the state
	 */
	public Project_State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Project_State state) {
		this.state = state;
	}
	
	/**
	 * @return the team
	 */
	public List<User> getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(List<User> team) {
		this.team = team;
	}
	
}

