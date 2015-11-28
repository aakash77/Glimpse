package com.group4.glimpse.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_state")
public class Project_State {

	@Id
    @Column(name="project_state_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long project_state_id;
	
	@Id
	@Column(name="value",unique=true)
	private String value;
	
	/**
	 * @return the project_state_id
	 */
	public long getProject_state_id() {
		return project_state_id;
	}

	/**
	 * @param project_state_id the project_state_id to set
	 */
	public void setProject_state_id(long project_state_id) {
		this.project_state_id = project_state_id;
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
