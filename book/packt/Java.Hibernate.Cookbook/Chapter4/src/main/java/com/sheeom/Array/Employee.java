package com.sheeom.Array;

import java.util.Arrays;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column (name = "id")
	private long id;

	@Column (name = "name")
	private String name;

	@ElementCollection
	@IndexColumn(name="email_index")
	@CollectionTable(name = "email")
	private String[] emails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getEmails() {
		return emails;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Employee" 
		+ "\n\tId: " + this.id + "\n\tName: " + this.name
				+ "\n\tEmails: " + Arrays.toString(this.emails);
	}
}
