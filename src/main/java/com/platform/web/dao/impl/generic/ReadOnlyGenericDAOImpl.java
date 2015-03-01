package com.platform.web.dao.impl.generic;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.platform.web.dao.generic.ReadOnlyGenericDAO;
import com.platform.web.model.DomainObject;

public class ReadOnlyGenericDAOImpl<T extends DomainObject> extends HibernateDaoSupport implements ReadOnlyGenericDAO<T> {

    private Class<T> entityClass;

    public ReadOnlyGenericDAOImpl(SessionFactory sessionFactory, Class<T> entityClass) {
	this.entityClass = entityClass;
	setSessionFactory(sessionFactory);
    }

    public Class<T> getPersistentClass() {
	return entityClass;
    }

    public T getById(Long id) {
	return getHibernateTemplate().get(entityClass, id);
    }

    public T loadById(Long id) {
	return getHibernateTemplate().load(entityClass, id);
    }

    public List<T> loadAll() {
	return getHibernateTemplate().loadAll(entityClass);
    }
}
