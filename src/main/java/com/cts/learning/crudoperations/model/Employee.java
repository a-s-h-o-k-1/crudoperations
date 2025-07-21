package com.cts.learning.crudoperations.model;

import java.util.List;

public class Employee {
	private Long id;

	private String name;

	private String email;

	private Department department; // Many employees can belong to one department

	private Address address; // One-to-one relationship

	private List<Project> projects; // One-to-many relationship

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(Long id, String name, String email, Department department, Address address,
			List<Project> projects) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.address = address;
		this.projects = projects;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", address=" + address + ", projects=" + projects + "]";
	}

}
