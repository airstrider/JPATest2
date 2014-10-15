package com.airstrider.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="employee", uniqueConstraints={@UniqueConstraint(columnNames="id")})
public class Employee implements Serializable{

	//Property
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Department department;
	private Set<Project> projects = new HashSet<Project>();
	
	//Getters/Setters
	@Id
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name", unique=false, nullable=false, insertable=true, updatable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(cascade={}, fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id", unique=false, nullable=false, insertable=true, updatable=true)
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}	
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinTable(name="employee_project", joinColumns={@JoinColumn(name="emp_id", nullable=false, updatable=false)},
										inverseJoinColumns={@JoinColumn(name="project_id", nullable=false, updatable=false)})
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
