package com.tactfactory.webposter.database.dao.base;

import com.tactfactory.webposter.database.base.DbEntity;

import java.util.List;

public interface BaseDao<T extends DbEntity> {

    T select(Long id);

    List<T> select();

    boolean delete(Long id);

    T save(T item);
}