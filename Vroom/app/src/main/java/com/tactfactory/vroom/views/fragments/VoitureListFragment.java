package com.tactfactory.vroom.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.utils.VoitureUtils;
import com.tactfactory.vroom.views.activities.GaragisteDetailsActivity;
import com.tactfactory.vroom.views.adapters.VoitureListRecyclerViewAdapter;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class VoitureListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private List<Voiture> voitures;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VoitureListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_voiture, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            if (voitures == null){
                recyclerView.setAdapter(new VoitureListRecyclerViewAdapter(VoitureUtils.generateVoituresAndGaragisteFullMapped(), mListener));
            }else{
                recyclerView.setAdapter(new VoitureListRecyclerViewAdapter(this.voitures, mListener));
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
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null && args.getSerializable(GaragisteDetailsFragment.FRAGMENT_ITEM)!=null){
            Garagiste garagiste = (Garagiste) args.getSerializable(GaragisteDetailsFragment.FRAGMENT_ITEM);
            this.voitures = garagiste.getVoitures();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Voiture item);
    }
}
