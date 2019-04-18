package com.tactfactory.webposter.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.fragments.PostListFragment;

public class PostListActivity extends AppCompatActivity implements PostListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
    }

    @Override
    public void onListFragmentInteraction(Post item) {

    }
}
