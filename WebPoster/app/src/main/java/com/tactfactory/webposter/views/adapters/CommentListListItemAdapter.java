package com.tactfactory.webposter.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.webposter.R;
import com.tactfactory.webposter.entities.Comment;

import java.util.List;

public class CommentListListItemAdapter extends RecyclerView.Adapter<CommentListListItemAdapter.ViewHolder> implements UpdatableListItem<List<Comment>> {

    private final List<Comment> mValues;

    public CommentListListItemAdapter(List<Comment> items) {
        mValues = items;
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
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void update(List<Comment> items) {
        mValues.clear();
        mValues.addAll(items);
        this.notifyDataSetChanged();
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
