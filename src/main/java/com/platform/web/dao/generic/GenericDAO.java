package com.platform.web.dao.generic;

import com.platform.web.model.DomainObject;

public interface GenericDAO<T extends DomainObject> extends ReadOnlyGenericDAO<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
