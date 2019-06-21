package com.tactfactory.vroom.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.fragments.VoitureListFragment;
import com.tactfactory.vroom.views.interfaces.UpdatableItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VoitureListRecyclerViewAdapter extends RecyclerView.Adapter<VoitureListRecyclerViewAdapter.ViewHolder> implements UpdatableItem<List<Voiture>> {

    private final List<Voiture> mValues;
    private final VoitureListFragment.OnListFragmentInteractionListener mListener;

    public VoitureListRecyclerViewAdapter(List<Voiture> items, VoitureListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_voiture_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNomView.setText(mValues.get(position).getNom());
        holder.mMarqueView.setText(mValues.get(position).getMarque());
        holder.mPlaqueView.setText(mValues.get(position).getPlaque());
        holder.mCouleurView.setText(mValues.get(position).getCouleur());

        LocalDate localDate = mValues.get(position).getDateDeMiseEnCirculation();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        holder.mDateMiseEnCirculationView.setText(localDate.format(formatter));

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

    @Override
    public void update(List<Voiture> items) {
        this.mValues.clear();
        this.mValues.addAll(items);
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNomView;
        public final TextView mMarqueView;
        public final TextView mPlaqueView;
        public final TextView mCouleurView;
        public final TextView mDateMiseEnCirculationView;
        public Voiture mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNomView = (TextView) view.findViewById(R.id.nom);
            mMarqueView = (TextView) view.findViewById(R.id.marque);
            mPlaqueView = (TextView) view.findViewById(R.id.plaque);
            mCouleurView = (TextView) view.findViewById(R.id.couleur);
            mDateMiseEnCirculationView = (TextView) view.findViewById(R.id.dateMiseEnCirculation);
        }
    }
}
