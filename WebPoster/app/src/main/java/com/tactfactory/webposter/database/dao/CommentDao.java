package com.tactfactory.webposter.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.webposter.database.dao.base.BaseDaoImp;
import com.tactfactory.webposter.database.dao.contracts.CommentContract;
import com.tactfactory.webposter.entities.Comment;

public class CommentDao extends BaseDaoImp<Comment> {

    public CommentDao() {
        super(new CommentContract());
    }

    @Override
    protected ContentValues contentValuesSetter(Comment item) {
        ContentValues values = new ContentValues();
        values.put(CommentContract.COL_BODY, item.getBody());
        values.put(CommentContract.COL_EMAIL, item.getEmail());
        values.put(CommentContract.COL_NAME, item.getName());
        values.put(CommentContract.COL_POST_ID, item.getPostId());

        return values;
    }

    @Override
    protected Comment cursorToJava(Cursor cursor) {
        Comment comment = new Comment();

        comment.setId(cursor.getLong(cursor.getColumnIndex(CommentContract.COL_ID)));
        comment.setPostId(cursor.getLong(cursor.getColumnIndex(CommentContract.COL_POST_ID)));
        comment.setBody(cursor.getString(cursor.getColumnIndex(CommentContract.COL_BODY)));
        comment.setName(cursor.getString(cursor.getColumnIndex(CommentContract.COL_NAME)));
        comment.setEmail(cursor.getString(cursor.getColumnIndex(CommentContract.COL_EMAIL)));

        return comment;
    }
}
