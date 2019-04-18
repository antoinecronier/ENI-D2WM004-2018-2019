package com.tactfactory.webposter.views.adapters;

import android.os.AsyncTask;

import com.tactfactory.webposter.database.dao.base.BaseDao;
import com.tactfactory.webposter.webservice.base.BaseWebService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UpdatableListItemViewUpdater<T extends UpdatableItem,K> extends AsyncTask<Long,Void,K> {

    private UpdatableListItem recyclerView;
    private BaseWebService<T,K> webService;
    private BaseDao<T> dao;

    public UpdatableListItemViewUpdater(UpdatableListItem view, BaseWebService<T,K> webService) {
        this.recyclerView = view;
        this.webService = webService;
    }

    public UpdatableListItemViewUpdater(UpdatableListItem view, BaseDao<T> dao) {
        this.recyclerView = view;
        this.dao = dao;
    }

    public UpdatableListItemViewUpdater(UpdatableListItem view, BaseWebService<T,K> webService, BaseDao<T> dao) {
        this.recyclerView = view;
        this.webService = webService;
        this.dao = dao;
    }

    @Override
    protected K doInBackground(Long... datas) {
        K result = null;

        // Get datas
        if (this.webService != null){
            try {
                result = this.webService.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            if(this.dao != null){
                if(datas != null && datas.length > 0){
                    result = (K) this.dao.select(datas[0]);
                }else{
                    result = (K) this.dao.select();
                }
            }
        }

        return result;
    }

    @Override
    protected void onPostExecute(K items) {
        super.onPostExecute(items);

        recyclerView.update(items);
    }
}
