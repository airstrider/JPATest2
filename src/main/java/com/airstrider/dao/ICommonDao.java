package com.airstrider.dao;

import javax.persistence.EntityManager;

public interface ICommonDao {
	Object findById(Object object, EntityManager manager);
	void create(Object object, EntityManager manager);
	void update(Object object, EntityManager manager);
	void delete(Object object, EntityManager manager);
}
