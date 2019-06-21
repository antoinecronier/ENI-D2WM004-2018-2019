package com.tactfactory.vroom.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.database.DatabaseHelper;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.views.fragments.GaragisteListFragment.OnListFragmentInteractionListener;
import com.tactfactory.vroom.views.interfaces.UpdatableItem;

import java.util.List;

public class GaragisteListRecyclerViewAdapter extends RecyclerView.Adapter<GaragisteListRecyclerViewAdapter.ViewHolder> implements UpdatableItem<List<Garagiste>> {

    private final List<Garagiste> mValues;
    private final OnListFragmentInteractionListener mListener;

    public GaragisteListRecyclerViewAdapter(List<Garagiste> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_garagiste_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.itemFirstname.setText(mValues.get(position).getFirstname());
        holder.itemLastname.setText(mValues.get(position).getLastname());
        holder.itemGarageName.setText(mValues.get(position).getGarageName());
        holder.itemAddress.setText(mValues.get(position).getAddress());
        holder.itemTelNumber.setText(mValues.get(position).getTelNumber());

        holder.itemClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        holder.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DatabaseHelper.getInstance().getDatabase().garagisteDao().delete(holder.mItem);
                    }
                }).start();

                GaragisteListRecyclerViewAdapter.this.mValues.remove(holder.mItem);
                GaragisteListRecyclerViewAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void update(List<Garagiste> items) {
        this.mValues.clear();
        this.mValues.addAll(items);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView itemFirstname;
        public final TextView itemLastname;
        public final TextView itemGarageName;
        public final TextView itemAddress;
        public final TextView itemTelNumber;
        public final LinearLayout itemClickable;
        public final Button itemDelete;
        public Garagiste mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            itemFirstname = (TextView) view.findViewById(R.id.garagisteFirstname);
            itemLastname = (TextView) view.findViewById(R.id.garagisteLastname);
            itemGarageName = (TextView) view.findViewById(R.id.garagisteGarageName);
            itemAddress = (TextView) view.findViewById(R.id.garagisteAdress);
            itemTelNumber = (TextView) view.findViewById(R.id.garagisteTelNumber);
            itemDelete = (Button) view.findViewById(R.id.garagiste_item_button);
            itemClickable = (LinearLayout) view.findViewById(R.id.garagiste_item_clickable);
        }
    }
}
