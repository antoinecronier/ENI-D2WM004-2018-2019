package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class UserContract extends ContractBase {
    public static final String TABLE_NAME = "user";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_EMAIL = "email";
    public static final String COL_PHONE = "phone";
    public static final String COL_WEBSITE = "website";
    public static final String COL_ADDRESS_ID = "address_id";
    public static final String COL_COMPANY_ID = "company_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NAME,
            COL_USERNAME,
            COL_EMAIL,
            COL_PHONE,
            COL_WEBSITE
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_NAME,
            COL_USERNAME,
            COL_EMAIL,
            COL_PHONE,
            COL_WEBSITE,
            COL_ADDRESS_ID,
            COL_COMPANY_ID
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_USERNAME + " TEXT," +
                    COL_EMAIL + " TEXT," +
                    COL_PHONE + " TEXT," +
                    COL_WEBSITE + " TEXT," +
                    COL_ADDRESS_ID + " INTEGER," +
                    COL_COMPANY_ID + " INTEGER" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public UserContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
