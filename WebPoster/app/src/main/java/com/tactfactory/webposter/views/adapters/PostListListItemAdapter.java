package com.tactfactory.webposter.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Post;
import com.tactfactory.webposter.views.fragments.PostListFragment.OnListFragmentInteractionListener;

import java.util.List;

public class PostListListItemAdapter extends RecyclerView.Adapter<PostListListItemAdapter.ViewHolder> implements UpdatableListItem<List<Post>> {

    private final List<Post> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PostListListItemAdapter(List<Post> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPostTitle.setText(mValues.get(position).getTitle());
        holder.mPostBody.setText(mValues.get(position).getBody());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentClicked(holder.mItem);
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentLongClicked(holder.mItem);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void update(List<Post> items) {
        mValues.clear();
        mValues.addAll(items);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mPostTitle;
        public final TextView mPostBody;
        public Post mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPostTitle = (TextView) view.findViewById(R.id.fragmentPostTitle);
            mPostBody = (TextView) view.findViewById(R.id.fragmentPostBody);
        }
    }
}
