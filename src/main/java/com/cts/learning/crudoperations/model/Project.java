package com.cts.learning.crudoperations.model;

public class Project {
	private Long id;

	private String title;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Project() {
		super();
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

}