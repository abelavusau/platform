package com.platform.web.dao.impl.generic;

import org.hibernate.SessionFactory;

import com.platform.web.dao.generic.GenericDAO;
import com.platform.web.model.DomainObject;

public class GenericDAOImpl<T extends DomainObject> extends ReadOnlyGenericDAOImpl<T> implements GenericDAO<T> {

    public GenericDAOImpl(SessionFactory sessionFactory, Class<T> entityClass) {
	super(sessionFactory, entityClass);
    }

    public void create(T entity) {
	getHibernateTemplate().save(entity);
    }

    public void update(T entity) {
	getHibernateTemplate().update(entity);
    }

    public void delete(T entity) {
	getHibernateTemplate().delete(entity);
    }
}
