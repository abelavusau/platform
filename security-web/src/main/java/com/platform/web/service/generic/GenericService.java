package com.platform.web.service.generic;

import com.platform.web.model.DomainObject;

public interface GenericService<T extends DomainObject> extends
		ReadOnlyGenericService<T> {
	Long create(T entity);

	void update(T entity);

	void delete(T entity);
}
