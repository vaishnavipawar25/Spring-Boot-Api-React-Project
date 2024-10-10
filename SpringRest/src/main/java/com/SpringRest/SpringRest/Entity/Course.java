package com.SpringRest.SpringRest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//occurs because Jackson cannot serialize the proxy object that Hibernate creates for lazily loaded entities.
//Solution:
//You can resolve this issue by forcing the loading of the actual entity before returning it to Jackson.
@Entity
public class Course {
	@Id
	private long  id;
	private String title;
	private String description;
	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Course() {
		super();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
