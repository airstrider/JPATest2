package com.airstrider.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.airstrider.dao.impl.CommonDao;
import com.airstrider.dao.impl.DepartmentDao;
import com.airstrider.dao.impl.EmployeeDao;
import com.airstrider.dao.impl.ProjectDao;
import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;
import com.airstrider.service.ICommonService;
import com.airstrider.util.EntityManagerUtil;

public class CommonService implements ICommonService {
//public class CommonService {
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
//	@Override
	public void batchSave(Map<String, Object> map) {
    	System.out.println( "- CommonService.batchSave() start -" );
    	
		//1. Open a connection and get an entity manager object
		manager = EntityManagerUtil.getEntityManager();
		//2. Start transaction
		manager.getTransaction().begin();
    	
		if(map.containsKey("dept")) {
			@SuppressWarnings("unchecked")
			List<LinkedHashMap<String, String>> data = (ArrayList<LinkedHashMap<String, String>>)map.get("dept");

			for (LinkedHashMap<String, String> lh : data) {
				departmentDao.create(EntityManagerUtil.setRequestObject("dept", lh), manager);
			}
		}
		if(map.containsKey("emp")) {
			@SuppressWarnings("unchecked")
			List<LinkedHashMap<String, String>> data = (ArrayList<LinkedHashMap<String, String>>)map.get("emp");
	
			for (LinkedHashMap<String, String> lh : data) {
				employeeDao.create(EntityManagerUtil.setRequestObject("emp", lh), manager);
			}
		}
		if(map.containsKey("pjt")) {
			@SuppressWarnings("unchecked")
			List<LinkedHashMap<String, String>> data = (ArrayList<LinkedHashMap<String, String>>)map.get("pjt");
	
			for (LinkedHashMap<String, String> lh : data) {
				projectDao.create(EntityManagerUtil.setRequestObject("pjt", lh), manager);
			}
		}

		//4. Commit the transaction
		manager.getTransaction().commit();
		//5. Close the connection
		manager.close();
		System.out.println( "- CommonService.batchSave() end -" );
	}
	
//	@Override
//	public void batchSave(Map<String, Object> map) {
//    	System.out.println( "- CommonService.batchPersist() start -" );
//    	
//		departmentDao.create(map.get("dept"), manager);
//		employeeDao.create((Employee)map.get("emp"), manager);
//		projectDao.create((Project)map.get("pjt"), manager);
//    	
//		System.out.println( "- CommonService.batchPersist() end -" );
//	}

//	@Override
	public void batchUpdate(Map<String, Object> map) {
    	System.out.println( "- CommonService.batchUpdate() start -" );

		employeeDao.update(map.get("emp"), manager);

		System.out.println( "- CommonService.batchUpdate() end -" );
	}
	
//	@Override
	public Object findById(Object object) {
    	System.out.println( "- CommonService.findById() start -" );
    	Object result = null;
	
		//1. Open a connection and get an entity manager object
		manager = EntityManagerUtil.getEntityManager();
		//2. Start transaction
		manager.getTransaction().begin();

    	if(object instanceof Department) {
    		result = departmentDao.findById(object, manager);
    	} else if (object instanceof Employee) {
    		result = employeeDao.findById(object, manager);
    	} else if (object instanceof Project) {
    		result = projectDao.findById(object, manager);
    	}
		System.out.println( "- CommonService.findById() end -" );

		//4. Commit the transaction
		manager.getTransaction().commit();
		//5. Close the connection
		manager.close();
		
		return result;
	}
}
