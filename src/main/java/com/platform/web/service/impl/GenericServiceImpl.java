package com.platform.web.service.impl;

import com.platform.web.dao.GenericDAO;
import com.platform.web.model.DomainObject;
import com.platform.web.service.GenericService;

public class GenericServiceImpl<T extends DomainObject> extends ReadOnlyGenericServiceImpl<T> implements GenericService<T> {
    private GenericDAO<T> dao;
    
    public GenericServiceImpl(GenericDAO<T> dao) {
	super(dao);
	this.dao = dao;
    }

    public Long create(T entity) {
	return dao.create(entity);
    }

    public void update(T entity) {
	dao.update(entity);
    }

    public void delete(T entity) {
	dao.delete(entity);
    }
}
