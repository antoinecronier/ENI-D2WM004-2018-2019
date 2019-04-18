package com.tactfactory.webposter.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Comment;
import com.tactfactory.webposter.views.fragments.CommentListFragment.OnListFragmentInteractionListener;

import java.util.List;

public class CommentListRecyclerViewAdapter extends RecyclerView.Adapter<CommentListRecyclerViewAdapter.ViewHolder> {

    private final List<Comment> mValues;
    private final OnListFragmentInteractionListener mListener;

    public CommentListRecyclerViewAdapter(List<Comment> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCommentName.setText(mValues.get(position).getName());
        holder.mCommentBody.setText(mValues.get(position).getBody());
        holder.mCommentEmail.setText(mValues.get(position).getEmail());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCommentName;
        public final TextView mCommentBody;
        public final TextView mCommentEmail;
        public Comment mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCommentName = (TextView) view.findViewById(R.id.fragmentCommentName);
            mCommentBody = (TextView) view.findViewById(R.id.fragmentCommentBody);
            mCommentEmail = (TextView) view.findViewById(R.id.fragmentCommentEmail);
        }
    }
}
