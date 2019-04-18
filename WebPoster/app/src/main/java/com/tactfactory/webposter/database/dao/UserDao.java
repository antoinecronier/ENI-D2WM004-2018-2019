package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.DbManager;
import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.AddressContract;
import com.tactfactory.webposter.database.dao.contracts.CompanyContract;
import com.tactfactory.webposter.database.dao.contracts.UserContract;
import com.tactfactory.webposter.entities.Company;
import com.tactfactory.webposter.entities.User;

public class UserDao extends BaseDaoImp<User> {

    public UserDao() {
        super(new UserContract());
    }

    @Override
    protected ContentValues contentValuesSetter(User item) {
        ContentValues values = new ContentValues();
//        values.put(UserContract.COL_ADDRESS_ID, item.getAddress().getId());
//        values.put(UserContract.COL_COMPANY_ID, item.getCompany().getId());
        values.put(UserContract.COL_EMAIL, item.getEmail());
        values.put(UserContract.COL_NAME, item.getName());
        values.put(UserContract.COL_PHONE, item.getPhone());
        values.put(UserContract.COL_USERNAME, item.getUsername());
        values.put(UserContract.COL_WEBSITE, item.getWebsite());

        return values;
    }

    @Override
    protected User cursorToJava(Cursor cursor) {
        User user = new User();

        user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.COL_ID)));

//        Long addressId = cursor.getLong(cursor.getColumnIndex(UserContract.COL_ADDRESS_ID));
//        Long companyId = cursor.getLong(cursor.getColumnIndex(UserContract.COL_ADDRESS_ID));
//
//        if (addressId != null || companyId != null){
//            DbManager dbManager = new DbManager();
//
//            if (addressId != null){
//                user.setAddress(dbManager.getAddressDao().select(addressId));
//            }
//
//            if (companyId != null){
//                user.setCompany(dbManager.getCompanyDao().select(companyId));
//            }
//        }

        user.setEmail(cursor.getString(cursor.getColumnIndex(UserContract.COL_EMAIL)));
        user.setName(cursor.getString(cursor.getColumnIndex(UserContract.COL_NAME)));
        user.setPhone(cursor.getString(cursor.getColumnIndex(UserContract.COL_PHONE)));
        user.setUsername(cursor.getString(cursor.getColumnIndex(UserContract.COL_USERNAME)));
        user.setWebsite(cursor.getString(cursor.getColumnIndex(UserContract.COL_WEBSITE)));

        return user;
    }
}
