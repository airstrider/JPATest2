package com.airstrider.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="project", uniqueConstraints={@UniqueConstraint(columnNames="id")})
public class Project implements Serializable {
	//Property
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String projectName;
	private Set<Employee> employees = new HashSet<Employee>();
	
	//Getters/Setters
	@Id
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="project_name", unique=false, nullable=true, insertable=true, updatable=true)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="projects")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
