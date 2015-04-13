package com.platform.web.dao.generic;

import java.util.List;

import com.platform.web.model.DomainObject;

public interface ReadOnlyGenericDAO<T extends DomainObject> {
	Class<T> getPersistentClass();

	T getById(Long id);

	T loadById(Long id);

	List<T> loadAll();
}
