package fr.acos.androkado.views.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.acos.androkado.R;
import fr.acos.androkado.entities.Utilisateur;
import fr.acos.androkado.utils.UpdatableAdapter;
import fr.acos.androkado.views.fragments.UtilisateurFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Utilisateur} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUtilisateurRecyclerViewAdapter extends RecyclerView.Adapter<MyUtilisateurRecyclerViewAdapter.ViewHolder> implements UpdatableAdapter<Utilisateur> {

    private final List<Utilisateur> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyUtilisateurRecyclerViewAdapter(List<Utilisateur> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_utilisateur, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNom());
        holder.mContentView.setText(mValues.get(position).getPrenom());

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
        public final TextView mIdView;
        public final TextView mContentView;
        public Utilisateur mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    @Override
    public void updateList(List<Utilisateur> datas){
        mValues.clear();
        mValues.addAll(datas);
        this.notifyDataSetChanged();
    }
}
