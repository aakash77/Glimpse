package com.group4.glimpse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Group 4 
 * Email Validation POJO class
 */
@Entity
@Table(name="EmailValidation", uniqueConstraints = { @UniqueConstraint(columnNames = {
"email"}) })
public class EmailValidation {

		@Id
	    @Column(name="idEmailValidation")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long idEmailValidation;
		
		@Column(name="name")
	    private String name;
		
		@Column(name="email",nullable=false)
	    private String email;

		@Column(name="password")
		private String password;
		
		@Column(name="status")
		private String status;
		
		

		public long getIdEmailValidation() {
			return idEmailValidation;
		}

		public void setIdEmailValidation(long idEmailValidation) {
			this.idEmailValidation = idEmailValidation;
		}


		/**
		 * @param set the status
		 */
		public String getStatus() {
			return status;
		}
		

		/**
		 * @return the status
		 */

		public void setStatus(String status) {
			this.status = status;
		}


		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

}
