package fr.acos.androkado.database.daos;

import java.util.List;

import fr.acos.androkado.database.base.DbEntity;
import fr.acos.androkado.utils.ProgressableActivity;
import fr.acos.androkado.utils.UpdatableAdapter;
import fr.acos.androkado.views.fragments.MyUtilisateurRecyclerViewAdapter;

public interface BaseDAO<T extends DbEntity> {

    T select(Long id);
    List<T> select();
    boolean update(T item);
    boolean delete(Long id);
    T insert(T item);

    List<T> select(ProgressableActivity progressBarActivity);
}
