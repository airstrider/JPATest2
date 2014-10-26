package com.airstrider.util;

import java.util.LinkedHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;

public class EntityManagerUtil {

	private static EntityManagerFactory factory = null;
	private static EntityManager entityMgr;
	private static Object requestObject;

	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("AIRSTRIDER");
		entityMgr = factory.createEntityManager();

		return entityMgr;
	}
	
	public static Object setRequestObject(String key, LinkedHashMap<String, String> lhm) {
		if(key.equalsIgnoreCase("dept")) {
			Department dept = new Department();
			dept.setId(Integer.parseInt(lhm.get("id")));
			dept.setName(lhm.get("name"));
			requestObject = dept;
		}
		if(key.equalsIgnoreCase("emp")) {
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(lhm.get("id")));
			emp.setName(lhm.get("name"));
			requestObject = emp;
		}
		if(key.equalsIgnoreCase("pjt")) {
			Project pjt = new Project();
			pjt.setId(Integer.parseInt(lhm.get("id")));
			pjt.setProjectName(lhm.get("name"));
			requestObject = pjt;
		}
		return requestObject;
	}

}//Class end
