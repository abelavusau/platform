package com.platform.web.service.impl.generic;

import java.util.List;

import com.platform.web.dao.generic.ReadOnlyGenericDAO;
import com.platform.web.model.DomainObject;
import com.platform.web.service.generic.ReadOnlyGenericService;

public class ReadOnlyGenericServiceImpl<T extends DomainObject> implements ReadOnlyGenericService<T> {
    
    private ReadOnlyGenericDAO<T> dao;
    
    public ReadOnlyGenericServiceImpl(ReadOnlyGenericDAO<T> dao) {
	this.dao = dao;
    }

    public T getById(Long id) {
	return dao.getById(id);
    }

    public T loadById(Long id) {
	return dao.loadById(id);
    }

    public List<T> loadAll() {
	return dao.loadAll();
    }

}
