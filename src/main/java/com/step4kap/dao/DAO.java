package com.step4kap.dao;

import com.step4kap.db.CommonEntity;

import java.util.Collection;

/**
 * Interface for data accsess objects
 */
public interface DAO<T extends CommonEntity<ID>, ID> {
    T getById(ID id);

    Collection<T> getAll();

    void save(T entity);

    void saveCollection(Collection<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    void update(T entity);
}
