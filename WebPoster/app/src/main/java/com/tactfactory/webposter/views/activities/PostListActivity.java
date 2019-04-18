package com.tactfactory.webposter.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PostListFragment fragment = new PostListFragment();
        fragmentTransaction.add(R.id.postListFragmentContainer, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentClicked(Post item) {
        Intent intent = new Intent(this,CommentListActivity.class);
        intent.putExtra(getString(R.string.PostListToCommentListItem),item);
        this.startActivity(intent);
    }

    @Override
    public void onListFragmentLongClicked(Post item) {
        Intent intent = new Intent(this,UserActivity.class);
        intent.putExtra(getString(R.string.PostListToUserItem),item);
        this.startActivity(intent);
    }
}
