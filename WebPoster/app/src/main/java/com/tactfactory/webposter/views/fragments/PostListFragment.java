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
import com.tactfactory.webposter.database.dao.PostDao;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.adapters.PostListListItemAdapter;
import com.tactfactory.webposter.views.adapters.UpdatableListItemViewUpdater;
import com.tactfactory.webposter.webservice.PostWebService;

import java.util.ArrayList;
import java.util.List;

public class PostListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private PostListListItemAdapter adapter;

    public PostListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.adapter = new PostListListItemAdapter(new ArrayList<Post>(), mListener);
            recyclerView.setAdapter(this.adapter);

            ConnectivityManager cm = (ConnectivityManager) WebPosterApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();

            if (ni != null && ni.isConnected()){
                new UpdatableListItemViewUpdater<Post,List<Post>>(this.adapter,new PostWebService()).execute();
            }else{
                new UpdatableListItemViewUpdater<Post,List<Post>>(this.adapter,new PostDao()).execute();
            }
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentClicked(Post item);
        void onListFragmentLongClicked(Post item);
    }
}
