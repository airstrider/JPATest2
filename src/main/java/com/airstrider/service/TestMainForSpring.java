package com.airstrider.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;
import com.airstrider.service.impl.CommonService;

public class TestMainForSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CommonService service = (CommonService)context.getBean("commonService");

		TestMainForSpring test = new TestMainForSpring();
		//1. Set a map object included data for persistence
		Map<String, Object> persistMap = new HashMap<String, Object>();
		persistMap.put("dept", test.setPersistDepartmentEntity());
		persistMap.put("emp", test.setPersistEmployeeEntity());
		persistMap.put("pjt", test.setPersistProjectEntity());

		//1. Set a map object included data for update
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("emp", test.setUpdateEntity());

//		service.batchPersist(persistMap);
		service.batchUpdate(updateMap);
	}

	private Department setPersistDepartmentEntity() {
    	Department dept = new Department();
    	dept.setId(1);
    	dept.setName("DEPT_01");
    	return dept;
	}
	
	private Employee setPersistEmployeeEntity() {
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
	
	private Project setPersistProjectEntity() {
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

	private Employee setUpdateEntity() {
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
