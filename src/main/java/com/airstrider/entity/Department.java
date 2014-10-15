package com.airstrider.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="department", uniqueConstraints={@UniqueConstraint(columnNames="id")})
public class Department implements Serializable {

	//Property
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
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
	
	@Column(name="dept_name", unique=false, nullable=false, insertable=true, updatable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="department")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
