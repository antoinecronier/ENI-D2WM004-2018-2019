package com.tactfactory.webposter.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.views.fragments.CommentListFragment;

public class CommentListActivity extends AppCompatActivity implements CommentListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
    }

    @Override
    public void onListFragmentInteraction(Comment item) {

    }
}
