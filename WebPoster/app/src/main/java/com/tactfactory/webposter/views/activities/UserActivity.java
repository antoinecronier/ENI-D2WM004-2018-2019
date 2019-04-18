package com.tactfactory.webposter.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.fragments.CommentListFragment;
import com.tactfactory.webposter.views.fragments.UserFragment;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = this.getIntent();
        Bundle bundle = null;

        if (intent != null){
            Post post = (Post) intent.getSerializableExtra(getString(R.string.PostListToUserItem));
            bundle = new Bundle();
            bundle.putSerializable(getString(R.string.PostListToUserItem),post);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UserFragment fragment = new UserFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.userFragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
