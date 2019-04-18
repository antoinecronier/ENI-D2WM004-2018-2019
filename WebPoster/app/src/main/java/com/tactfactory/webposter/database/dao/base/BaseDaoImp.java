package com.tactfactory.webposter.database.dao.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tactfactory.webposter.database.DbOpenHelper;
import com.tactfactory.webposter.database.base.DbEntity;
import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImp<T extends DbEntity> implements BaseDao<T> {

    private SQLiteDatabase db = null;
    private ContractBase contractBase;

    public BaseDaoImp(ContractBase contractBase){
        this.contractBase = contractBase;
        this.db = DbOpenHelper.getInstance().getDb();
    }

    @Override
    public T select(Long id) {
        T result = null;

        Cursor cursor = db.query(
                contractBase.TABLE_NAME,
                contractBase.ALL_SELECT_WITH_LINKS,
                contractBase.COL_ID + "=?",
                new String[]{id.toString()},
                null,
                null,
                null
        );

        if(cursor.moveToNext()){
            result = this.cursorToJava(cursor);
        }

        cursor.close();

        return result;
    }

    @Override
    public List<T> select() {
        List<T> result = new ArrayList<T>();

        final Cursor cursor = db.query(
                contractBase.TABLE_NAME,
                contractBase.ALL_SELECT_WITH_LINKS,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()){
            result.add(this.cursorToJava(cursor));
        }

        cursor.close();

        return result;
    }

    @Override
    public boolean delete(Long id) {
        String[] whereDatas = new String[1];
        whereDatas[0] = id.toString();
        int result = db.delete(contractBase.TABLE_NAME,
                contractBase.COL_ID + "=?",whereDatas);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public T save(T item) {
        ContentValues values = this.contentValuesSetter(item);

        if (item.getId() == null){
            item.setId(db.insert(contractBase.TABLE_NAME,null,values));
        }else{
            String[] whereDatas = new String[1];
            whereDatas[0] = item.getId().toString();
            db.update(contractBase.TABLE_NAME,values,
                    contractBase.COL_ID + "=?",whereDatas);
        }

        return item;
    }

    @Override
    public T save(T item, boolean forceInsert) {
        if(forceInsert){
            item.setId(null);
        }

        return save(item);
    }

    protected abstract ContentValues contentValuesSetter(T item);
    protected abstract T cursorToJava(Cursor cursor);
}
