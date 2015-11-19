package com.group4.glimpse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	
	private User owner;
	
	@Column(name="state")
	private State state;
	
	/*public enum state {
		Planning, Ongoing, Cancelled, Completed
	}*/
}