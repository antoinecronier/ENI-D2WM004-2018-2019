package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class AddressContract extends ContractBase {
    public static final String TABLE_NAME = "address";

    public static final String COL_ID = "id";
    public static final String COL_STREET = "name";
    public static final String COL_SUITE = "username";
    public static final String COL_CITY = "email";
    public static final String COL_ZIPCODE = "phone";
    public static final String COL_GEO_ID = "geo_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_STREET,
            COL_SUITE,
            COL_CITY,
            COL_ZIPCODE
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_STREET,
            COL_SUITE,
            COL_CITY,
            COL_ZIPCODE,
            COL_GEO_ID
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_STREET + " TEXT," +
                    COL_SUITE + " TEXT," +
                    COL_CITY + " TEXT," +
                    COL_ZIPCODE + " TEXT," +
                    COL_GEO_ID + " INTEGER" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public AddressContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
