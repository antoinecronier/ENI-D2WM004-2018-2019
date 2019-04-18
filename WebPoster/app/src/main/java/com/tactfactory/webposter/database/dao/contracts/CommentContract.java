package com.tactfactory.webposter.database.dao.contracts;

import com.tactfactory.webposter.database.dao.contracts.base.ContractBase;

public class CommentContract extends ContractBase {
    public static final String TABLE_NAME = "comment";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_BODY = "body";
    public static final String COL_POST_ID = "post_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NAME,
            COL_EMAIL,
            COL_BODY
    };

    public static final String[] ALL_SELECT_WITH_LINKS = new String[]{
            COL_ID,
            COL_NAME,
            COL_EMAIL,
            COL_BODY,
            COL_POST_ID
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_EMAIL + " TEXT," +
                    COL_BODY + " TEXT," +
                    COL_POST_ID + " INTEGER" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public CommentContract() {
        super(TABLE_NAME, COL_ID, ALL_SELECT, ALL_SELECT_WITH_LINKS, CREATE_TABLE, DROP_TABLE);
    }
}
