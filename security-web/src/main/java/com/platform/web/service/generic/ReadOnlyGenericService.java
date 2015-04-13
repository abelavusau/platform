package com.platform.web.service.generic;

import java.util.List;

import com.platform.web.model.DomainObject;

public interface ReadOnlyGenericService<T extends DomainObject> {
	T getById(Long id);

	T loadById(Long id);

	List<T> loadAll();
}
