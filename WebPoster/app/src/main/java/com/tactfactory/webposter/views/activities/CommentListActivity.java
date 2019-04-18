package com.tactfactory.webposter.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.fragments.CommentListFragment;
import com.tactfactory.webposter.views.fragments.PostListFragment;

public class CommentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        Intent intent = this.getIntent();
        Bundle bundle = null;

        if (intent != null){
            Post post = (Post) intent.getSerializableExtra(getString(R.string.PostListToCommentListItem));
            bundle = new Bundle();
            bundle.putSerializable(getString(R.string.PostListToCommentListItem),post);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CommentListFragment fragment = new CommentListFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.commentListFragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
