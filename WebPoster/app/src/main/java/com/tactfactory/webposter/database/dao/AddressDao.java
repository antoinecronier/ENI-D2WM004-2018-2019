package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.DbManager;
import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.AddressContract;
import com.tactfactory.webposter.entities.Address;

public class AddressDao extends BaseDaoImp<Address> {

    public AddressDao() {
        super(new AddressContract());
    }

    @Override
    protected ContentValues contentValuesSetter(Address item) {
        ContentValues values = new ContentValues();
        values.put(AddressContract.COL_CITY,item.getCity());
        if(item.getGeo() != null){
            values.put(AddressContract.COL_GEO_ID,item.getGeo().getId());
        }
        values.put(AddressContract.COL_STREET,item.getStreet());
        values.put(AddressContract.COL_SUITE,item.getSuite());
        values.put(AddressContract.COL_ZIPCODE,item.getZipcode());

        return values;
    }

    @Override
    protected Address cursorToJava(Cursor cursor) {
        Address address = new Address();

        address.setId(cursor.getLong(cursor.getColumnIndex(AddressContract.COL_ID)));
        address.setCity(cursor.getString(cursor.getColumnIndex(AddressContract.COL_CITY)));

        Long geoId = cursor.getLong(cursor.getColumnIndex(AddressContract.COL_GEO_ID));

        if (geoId != null){
            DbManager dbManager = new DbManager();
            address.setGeo(dbManager.getGeoDao().select(geoId));
        }

        address.setStreet(cursor.getString(cursor.getColumnIndex(AddressContract.COL_STREET)));
        address.setSuite(cursor.getString(cursor.getColumnIndex(AddressContract.COL_SUITE)));
        address.setZipcode(cursor.getString(cursor.getColumnIndex(AddressContract.COL_ZIPCODE)));

        return address;
    }
}
