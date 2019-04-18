package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.CompanyContract;
import com.tactfactory.webposter.entities.Company;

public class CompanyDao extends BaseDaoImp<Company> {

    public CompanyDao() {
        super(new CompanyContract());
    }

    @Override
    protected ContentValues contentValuesSetter(Company item) {
        ContentValues values = new ContentValues();
        values.put(CompanyContract.COL_BS, item.getBs());
        values.put(CompanyContract.COL_CATCH_PHRASE, item.getCatchPhrase());
        values.put(CompanyContract.COL_NAME, item.getName());

        return values;
    }

    @Override
    protected Company cursorToJava(Cursor cursor) {
        Company company = new Company();

        company.setId(cursor.getLong(cursor.getColumnIndex(CompanyContract.COL_ID)));
        company.setBs(cursor.getString(cursor.getColumnIndex(CompanyContract.COL_BS)));
        company.setName(cursor.getString(cursor.getColumnIndex(CompanyContract.COL_NAME)));
        company.setCatchPhrase(cursor.getString(cursor.getColumnIndex(CompanyContract.COL_CATCH_PHRASE)));

        return company;
    }
}
