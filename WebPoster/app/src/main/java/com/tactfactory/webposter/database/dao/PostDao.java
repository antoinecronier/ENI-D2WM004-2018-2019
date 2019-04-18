package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.PostContract;
import com.tactfactory.webposter.entities.Post;

public class PostDao extends BaseDaoImp<Post> {

    public PostDao() {
        super(new PostContract());
    }

    @Override
    protected ContentValues contentValuesSetter(Post item) {
        ContentValues values = new ContentValues();
        values.put(PostContract.COL_BODY, item.getBody());
        values.put(PostContract.COL_TITLE, item.getTitle());
        values.put(PostContract.COL_USER_ID, item.getUserId());

        return values;
    }

    @Override
    protected Post cursorToJava(Cursor cursor) {
        Post post = new Post();

        post.setId(cursor.getLong(cursor.getColumnIndex(PostContract.COL_ID)));
        post.setUserId(cursor.getLong(cursor.getColumnIndex(PostContract.COL_USER_ID)));
        post.setBody(cursor.getString(cursor.getColumnIndex(PostContract.COL_BODY)));
        post.setTitle(cursor.getString(cursor.getColumnIndex(PostContract.COL_TITLE)));

        return post;
    }
}
