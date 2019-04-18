package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class CompanyContract extends ContractBase {
    public static final String TABLE_NAME = "company";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_CATCH_PHRASE = "catch_phrase";
    public static final String COL_BS = "bs";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NAME,
            COL_CATCH_PHRASE,
            COL_BS
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_NAME,
            COL_CATCH_PHRASE,
            COL_BS
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_CATCH_PHRASE + " TEXT," +
                    COL_BS + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public CompanyContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
