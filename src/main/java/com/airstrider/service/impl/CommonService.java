package com.airstrider.service.impl;

import java.util.Map;

import javax.persistence.EntityManager;

import com.airstrider.dao.impl.CommonDao;
import com.airstrider.dao.impl.DepartmentDao;
import com.airstrider.dao.impl.EmployeeDao;
import com.airstrider.dao.impl.ProjectDao;
import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;

public class CommonService {
	//Property
	EntityManager manager = null;

	CommonDao commonDao;
	DepartmentDao departmentDao;
	EmployeeDao employeeDao;
	ProjectDao projectDao;

	//Setters
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	//Methods
	public void batchSave(Map<String, Object> map) {
    	System.out.println( "- CommonService.batchPersist() start -" );
    	
		departmentDao.create((Department)map.get("dept"), manager);
		employeeDao.create((Employee)map.get("emp"), manager);
		projectDao.create((Project)map.get("pjt"), manager);
    	
		System.out.println( "- CommonService.batchPersist() end -" );
	}
	
	public void batchUpdate(Map<String, Object> map) {
    	System.out.println( "- CommonService.batchUpdate() start -" );

		employeeDao.update((Employee)map.get("emp"), manager);

		System.out.println( "- CommonService.batchUpdate() end -" );
	}
}
