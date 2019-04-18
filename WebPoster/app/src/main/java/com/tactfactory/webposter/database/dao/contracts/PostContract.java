package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class PostContract extends ContractBase {
    public static final String TABLE_NAME = "post";

    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_BODY = "body";
    public static final String COL_USER_ID = "user_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_TITLE,
            COL_BODY
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_TITLE,
            COL_BODY,
            COL_USER_ID
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_TITLE + " TEXT," +
                    COL_BODY + " TEXT," +
                    COL_USER_ID + " INTEGER" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public PostContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
