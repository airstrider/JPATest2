package com.airstrider.dao.impl;

import javax.persistence.EntityManager;

import com.airstrider.dao.ICommonDao;
import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;
import com.airstrider.util.EntityManagerUtil;

public class CommonDao implements ICommonDao {

	public Object findById(Object object, EntityManager manager) {
		System.out.println("--- CommonDao.findById() start ---");
		Object result = null;
		
		//3. Find the result by id search
		try {
			if (object instanceof Department) {
				result = manager.find(Department.class, ((Department)object).getId());
//				System.out.println("result.getId(): "+((Department)result).getId());
//				System.out.println("result.getName(): "+((Department)result).getName());
			} else if (object instanceof Employee) {
				result = manager.find(Employee.class, ((Employee)object).getId());
			} else if (object instanceof Project) {
				result = manager.find(Project.class, ((Project)object).getId());
			}
		} catch(NullPointerException e) {
			System.err.println("\n***[ Exception: "+e.getMessage()+" ]***\n");
			System.err.println("\n***[ No such entity found ]***\n");
		}
		System.out.println("--- CommonDao.findById() end ---");
		
		return result;
	}

	public void create(Object object, EntityManager manager) {
		System.out.println("--- CommonDao.create() start ---");
		//3. Check the entity to persist
		if (object instanceof Department) {
			Department result = manager.find(Department.class, ((Department)object).getId());
			if (result == null) {
				//4. Save the entity
				manager.persist(object);
			} else {
				System.err.println("\n***[ Duplicate department data found ]***\n");
			}
		} else if(object instanceof Employee) {
			Employee result = manager.find(Employee.class, ((Employee)object).getId());
			if (result == null) {
				//4. Save the entity
				manager.persist(object);
			} else {
				System.err.println("\n***[ Duplicate employee data found ]***\n");
			}
		} else if(object instanceof Project) {
			Project result = manager.find(Project.class, ((Project)object).getId());
			if (result == null) {
				//4. Save the entity
				manager.persist(object);
			} else {
				System.err.println("\n***[ Duplicate project data found ]***\n");
			}
		} else {
			System.err.println("\n***[ No such type entity found ]***\n");			
		}
		System.out.println("--- CommonDao.create() end ---");
	}
	
	public void update(Object object, EntityManager manager) {
		System.out.println("--- CommonDao.update() start ---");
		//1. Open a connection and get an entity manager instance
		manager = EntityManagerUtil.getEntityManager();
		//2. Begin a transaction
		manager.getTransaction().begin();
		
		//3. Check the entity to update
		if (object instanceof Department) {
			Department result = manager.find(Department.class, ((Department)object).getId());
			if (result != null) {
				//4. Update the department entity
				result.setName(((Department)object).getName());
				System.out.println("\n***[ The department entity update complete ]***\n");
			} else {
				System.err.println("\n***[ No department entity to update ]***\n");
			}
		} else if (object instanceof Employee) {
			Employee result = manager.find(Employee.class, ((Employee)object).getId());
			if (result != null) {
				//4. Update the employee entity
				result.setId(((Employee)object).getId());
				result.setName(((Employee)object).getName());
				result.setDepartment(((Employee)object).getDepartment());
				result.setProjects(((Employee)object).getProjects());
				System.out.println("\n***[ The employee entity update complete ]***\n");
			} else {
				System.err.println("\n***[ No employee entity to update ]***\n");
			}
		} else if (object instanceof Project) {
			Project result = manager.find(Project.class, ((Project)object).getId());
			if (result != null) {
				//4. Update the project entity
				result.setId(((Project)object).getId());
				result.setProjectName(((Project)object).getProjectName());
				result.setEmployees(((Project)object).getEmployees());
				System.out.println("\n***[ The project entity update complete ]***\n");
			} else {
				System.err.println("\n***[ No project entity to update ]***\n");
			}
		} else {
			System.err.println("\n***[ No such type entity found ]***\n");
		}
		
		//5. Commit the transaction
		manager.getTransaction().commit();
		//6. Close the connection
		manager.close();
		System.out.println("--- CommonDao.update() end ---");
	}//update() end
	
	public void delete(Object object, EntityManager manager) {
		System.out.println("--- CommonDao.delete() start ---");
		//1. Open a connection and get an entity manager instance
		manager = EntityManagerUtil.getEntityManager();
		//2. Begin a transaction
		manager.getTransaction().begin();
		
		//3. Check the entity to delete
		if (object instanceof Department) {
			Department result = manager.find(Department.class, ((Department)object).getId());
			if (result != null) {
				//4. Delete the department entity
				manager.remove(result);
				System.out.println("\n***[ The department entity delete complete ]***\n");
			} else {
				System.err.println("\n***[ No department entity to delete ]***\n");
			}
		} else if (object instanceof Employee) {
			Employee result = manager.find(Employee.class, ((Employee)object).getId());
			if (result != null) {
				//4. Delete the employee entity
				manager.remove(result);
				System.out.println("\n***[ The employee entity delete complete ]***\n");
			} else {
				System.err.println("\n***[ No employee entity to delete ]***\n");
			}
		} else if (object instanceof Project) {
			Project result = manager.find(Project.class, ((Project)object).getId());
			if (result != null) {
				//4. Delete the project entity
				manager.remove(result);
				System.out.println("\n***[ The project entity delete complete ]***\n");
			} else {
				System.err.println("\n***[ No project entity to delete ]***\n");
			}
		} else {
			System.err.println("\n***[ No such type entity found ]***\n");
		}

		//5. Commit the transaction
		manager.getTransaction().commit();
		//6. Close the connection
		manager.close();
		System.out.println("--- CommonDao.delete() end ---");
	}//delete() end
}
