package com.platform.web.service.generic;

import com.platform.web.model.DomainObject;

public interface GenericService<T extends DomainObject> extends ReadOnlyGenericService<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
