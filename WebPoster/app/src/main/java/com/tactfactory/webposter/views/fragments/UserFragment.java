package com.tactfactory.webposter.views.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.WebPosterApplication;
import com.tactfactory.webposter.database.dao.UserDao;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.entities.User;
import com.tactfactory.webposter.views.adapters.UpdatableListItem;
import com.tactfactory.webposter.views.adapters.UpdatableListItemViewUpdater;
import com.tactfactory.webposter.webservice.UserWebServiceById;

public class UserFragment extends Fragment implements UpdatableListItem<User> {

    private Post post;
    private TextView nameTxtV;
    private TextView usernameTxtV;
    private TextView emailTxtV;
    private TextView phoneTxtV;
    private TextView websiteTxtV;

    public UserFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.post = (Post) this.getArguments().getSerializable(getString(R.string.PostListToUserItem));

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.nameTxtV = view.findViewById(R.id.fragmentUserName);
        this.usernameTxtV = view.findViewById(R.id.fragmentUserUsername);
        this.emailTxtV = view.findViewById(R.id.fragmentUserEmail);
        this.phoneTxtV = view.findViewById(R.id.fragmentUserPhone);
        this.websiteTxtV = view.findViewById(R.id.fragmentUserWebsite);

        ConnectivityManager cm = (ConnectivityManager) WebPosterApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null && ni.isConnected()){
            new UpdatableListItemViewUpdater<User,User>(this,new UserWebServiceById(this.post)).execute();
        }else{
            new UpdatableListItemViewUpdater<User,User>(this,new UserDao()).execute(this.post.getUserId());
        }
    }

    @Override
    public void update(User item) {
        this.nameTxtV.setText(item.getName());
        this.usernameTxtV.setText(item.getUsername());
        this.emailTxtV.setText(item.getEmail());
        this.phoneTxtV.setText(item.getPhone());
        this.websiteTxtV.setText(item.getWebsite());
    }
}
