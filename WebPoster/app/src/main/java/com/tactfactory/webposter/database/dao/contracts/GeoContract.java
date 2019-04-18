package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class GeoContract extends ContractBase {
    public static final String TABLE_NAME = "geo";

    public static final String COL_ID = "id";
    public static final String COL_LAT = "lat";
    public static final String COL_LNG = "lng";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_LAT,
            COL_LNG
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_LAT,
            COL_LNG
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_LAT + " REAL," +
                    COL_LNG + " REAL" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public GeoContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
