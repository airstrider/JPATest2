package com.airstrider.dao.impl;

import javax.persistence.EntityManager;

import com.airstrider.entity.Employee;

public class EmployeeDao extends CommonDao {

	@Override
	public Employee findById(Object object, EntityManager manager) {
		System.out.println("-- EmployeeDao.findById() start --");
		return (Employee)super.findById(object, manager);
	}//findById() end
	
	@Override
	public void create(Object object, EntityManager manager) {
		System.out.println("-- EmployeeDao.create() start --");
		super.create(object, manager);
		System.out.println("-- EmployeeDao.create() end --");
	}//create() end
	
	@Override
	public void update(Object object, EntityManager manager) {
		System.out.println("-- EmployeeDao.update() start --");
		super.update(object, manager);
		System.out.println("-- EmployeeDao.update() end --");
	}//update() end
	
	@Override
	public void delete(Object object, EntityManager manager) {
		System.out.println("-- EmployeeDao.delete() start --");
		super.delete(object, manager);
	}//delete

}
