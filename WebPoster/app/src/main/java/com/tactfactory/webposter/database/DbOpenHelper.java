package com.tactfactory.webposter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.tactfactory.webposter.WebPosterApplication;
import com.tactfactory.webposter.database.dao.contracts.AddressContract;
import com.tactfactory.webposter.database.dao.contracts.CommentContract;
import com.tactfactory.webposter.database.dao.contracts.CompanyContract;
import com.tactfactory.webposter.database.dao.contracts.GeoContract;
import com.tactfactory.webposter.database.dao.contracts.PostContract;
import com.tactfactory.webposter.database.dao.contracts.UserContract;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "webposter.db";

    private static DbOpenHelper INSTANCE = null;

    public static synchronized DbOpenHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DbOpenHelper(WebPosterApplication.getAppContext());
        }
        return INSTANCE;
    }

    private SQLiteDatabase db;

    private DbOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AddressContract.CREATE_TABLE);
        db.execSQL(CommentContract.CREATE_TABLE);
        db.execSQL(CompanyContract.CREATE_TABLE);
        db.execSQL(GeoContract.CREATE_TABLE);
        db.execSQL(PostContract.CREATE_TABLE);
        db.execSQL(UserContract.CREATE_TABLE);

        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AddressContract.DROP_TABLE);
        db.execSQL(CommentContract.DROP_TABLE);
        db.execSQL(CompanyContract.DROP_TABLE);
        db.execSQL(GeoContract.DROP_TABLE);
        db.execSQL(PostContract.DROP_TABLE);
        db.execSQL(UserContract.DROP_TABLE);
        onCreate(db);
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            db = this.getWritableDatabase();
        }
        return db;
    }
}
