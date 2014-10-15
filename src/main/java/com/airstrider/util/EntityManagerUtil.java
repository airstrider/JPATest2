package com.airstrider.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory factory = null;
	private static EntityManager entityMgr;

	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("AIRSTRIDER");
		entityMgr = factory.createEntityManager();

		return entityMgr;
	}

}//Class end
