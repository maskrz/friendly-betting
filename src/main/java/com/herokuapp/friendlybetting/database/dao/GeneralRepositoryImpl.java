package com.herokuapp.friendlybetting.database.dao;

import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.herokuapp.friendlybetting.database.entities.Logger;
import com.herokuapp.friendlybetting.database.entities.Tracker;

@Repository("generalRepository")
public class GeneralRepositoryImpl implements GeneralRepository {

	/** entity manager */
	@PersistenceContext(name="fbPU")
	private EntityManager entityManager;

	@Override
	public <T> T add(T entity) {
		if (entity instanceof Logger) {
			((Logger) entity).setCreateTimestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+1")).getTime());
			((Tracker) entity).setRefreshTimestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+1")).getTime());
		}
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public <T> T findById(Class<? extends T> entityClass, Object key) {
		if(key != null){
			return getEntityManager().find(entityClass, key);
		}
		return null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
