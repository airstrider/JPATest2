package com.airstrider.dao.impl;

import javax.persistence.EntityManager;

import com.airstrider.entity.Project;

public class ProjectDao extends CommonDao {

	@Override
	public Project findById(Object object, EntityManager manager) {
		System.out.println("-- ProjectDao.findById() start --");
		return (Project)super.findById(object, manager);
	}//findById() end
	
	@Override
	public void create(Object object, EntityManager manager) {
		System.out.println("-- ProjectDao.create() start --");
		super.create(object, manager);
		System.out.println("-- ProjectDao.create() end --");
	}//create() end
	
	@Override
	public void update(Object object, EntityManager manager) {
		System.out.println("-- ProjectDao.update() start --");
		super.update(object, manager);
		System.out.println("-- ProjectDao.update() end --");
	}//update() end
	
	@Override
	public void delete(Object object, EntityManager manager) {
		System.out.println("-- ProjectDao.delete() start --");
		super.delete(object, manager);
		System.out.println("-- ProjectDao.delete() end --");
	}//delete

}
