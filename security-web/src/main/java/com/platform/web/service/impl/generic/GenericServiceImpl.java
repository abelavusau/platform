package com.platform.web.service.impl.generic;

import org.springframework.transaction.annotation.Transactional;

import com.platform.web.dao.generic.GenericDAO;
import com.platform.web.model.DomainObject;
import com.platform.web.service.generic.GenericService;

@Transactional
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
