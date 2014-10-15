package com.airstrider.util;

import java.util.HashSet;
import java.util.Set;

import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;

public class TestEntityGenerator {

	public Department setPersistDepartmentEntity() {
    	Department dept = new Department();
    	dept.setId(1);
    	dept.setName("DEPT_01");
    	return dept;
	}
	
	public Employee setPersistEmployeeEntity() {
    	Department dept = new Department();
    	dept.setId(1);
    	dept.setName("DEPT_02");
    	
    	Set<Project> projects = new HashSet<Project>();
    	Project pjt1 = new Project();
    	pjt1.setId(1);
    	pjt1.setProjectName("PJT_01");
    	projects.add(pjt1);
    	
    	Employee emp = new Employee();
    	emp.setId(1);
    	emp.setName("KIM");
    	emp.setDepartment(dept);
//    	emp.setProjects(projects);
    	return emp;
	}
	
	public Project setPersistProjectEntity() {
    	Set<Employee> employees = new HashSet<Employee>();
    	Employee emp = new Employee();
    	emp.setId(1);
    	emp.setName("KIM");
    	employees.add(emp);

    	Project pjt = new Project();
    	pjt.setId(1);
    	pjt.setProjectName("PJT_01");
    	pjt.setEmployees(employees);
    	return pjt;
	}

	public Employee setUpdateEntity() {
    	Department dept = new Department();
    	dept.setId(1);
    	dept.setName("DEPT_02");
    	
    	Set<Project> projects = new HashSet<Project>();
    	Project pjt1 = new Project();
    	pjt1.setId(1);
    	pjt1.setProjectName("PJT_02");
    	projects.add(pjt1);
    	
    	Employee emp = new Employee();
    	emp.setId(1);
    	emp.setName("LEE");
    	emp.setDepartment(dept);
    	emp.setProjects(projects);
    	return emp;		
	}

}
