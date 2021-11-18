package com.soit.soitfaculty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {


	//Set the fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="title")
	private String title;


	//Set the Constructor
	public Faculty() {

	}

	public Faculty(int id, String firstName, String lastName, String email, String title) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.title = title;
	}


	//Set the Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", title=" + title + "]";
	}



}