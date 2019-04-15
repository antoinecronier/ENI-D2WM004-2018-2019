package fr.acos.androkado.database.daos;

import java.util.List;

import fr.acos.androkado.database.base.DbEntity;

public interface BaseDAO<T extends DbEntity> {

    T select(Long id);
    List<T> select();
    boolean update(T item);
    boolean delete(Long id);
    T insert(T item);
}
