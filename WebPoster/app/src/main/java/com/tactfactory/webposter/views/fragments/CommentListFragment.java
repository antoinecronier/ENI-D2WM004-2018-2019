package com.tactfactory.webposter.views.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.WebPosterApplication;
import com.tactfactory.webposter.database.dao.CommentDao;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.adapters.CommentListListItemAdapter;
import com.tactfactory.webposter.views.adapters.UpdatableListItemViewUpdater;
import com.tactfactory.webposter.webservice.CommentWebServiceByPost;

import java.util.ArrayList;
import java.util.List;

public class CommentListFragment extends Fragment {

    private Post post;
    private CommentListListItemAdapter adapter;

    public CommentListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.post = (Post) this.getArguments().getSerializable(getString(R.string.PostListToCommentListItem));

        View view = inflater.inflate(R.layout.fragment_comment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.adapter = new CommentListListItemAdapter(new ArrayList<Comment>());
            recyclerView.setAdapter(this.adapter);

            ConnectivityManager cm = (ConnectivityManager) WebPosterApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();

            if (ni != null && ni.isConnected()){
                new UpdatableListItemViewUpdater<Comment,List<Comment>>(this.adapter,new CommentWebServiceByPost(this.post)).execute();
            }else{
                new UpdatableListItemViewUpdater<Comment,List<Comment>>(this.adapter,new CommentDao()).execute();
            }
        }
        return view;
    }
}
