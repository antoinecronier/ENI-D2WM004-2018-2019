package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.GeoContract;
import com.tactfactory.webposter.entities.Geo;

public class GeoDao extends BaseDaoImp<Geo> {

    public GeoDao() {
        super(new GeoContract());
    }

    @Override
    protected ContentValues contentValuesSetter(Geo item) {
        ContentValues values = new ContentValues();
        values.put(GeoContract.COL_LAT, item.getLat());
        values.put(GeoContract.COL_LNG, item.getLng());

        return values;
    }

    @Override
    protected Geo cursorToJava(Cursor cursor) {
        Geo company = new Geo();

        company.setId(cursor.getLong(cursor.getColumnIndex(GeoContract.COL_ID)));
        company.setLat(cursor.getDouble(cursor.getColumnIndex(GeoContract.COL_LAT)));
        company.setLng(cursor.getDouble(cursor.getColumnIndex(GeoContract.COL_LNG)));

        return company;
    }
}
