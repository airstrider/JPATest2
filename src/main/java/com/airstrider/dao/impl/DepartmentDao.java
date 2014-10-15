package com.airstrider.dao.impl;

import javax.persistence.EntityManager;

import com.airstrider.entity.Department;

public class DepartmentDao extends CommonDao {
	CommonDao dao = new CommonDao();
	
	@Override
	public Department findById(Object object, EntityManager manager) {
		System.out.println("-- DepartmentDao.findById() start --");
		return (Department)super.findById(object, manager);
	}//findById() end
	
	@Override
	public void create(Object object, EntityManager manager) {
		System.out.println("-- DepartmentDao.create() start --");
		super.create(object, manager);
		System.out.println("-- DepartmentDao.create() end --");
	}//create() end
	
	@Override
	public void update(Object object, EntityManager manager) {
		System.out.println("-- DepartmentDao.update() start --");
		super.update(object, manager);
		System.out.println("-- DepartmentDao.update() end --");
	}//update() end
	
	@Override
	public void delete(Object object, EntityManager manager) {
		System.out.println("-- DepartmentDao.delete() start --");
		super.delete(object, manager);
		System.out.println("-- DepartmentDao.delete() end --");
	}//delete

}
