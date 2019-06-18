package com.tactfactory.vroom.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ContentFrameLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.activities.GaragisteDetailsActivity;
import com.tactfactory.vroom.views.activities.VoitureDetailsActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GaragisteDetailsFragment extends Fragment {
    public static final String FRAGMENT_ITEM = "fragmentItem";

    private OnFragmentInteractionListener mListener;

    private Garagiste garagiste;
    private TextView detailsFirstname;
    private TextView detailsLastname;
    private TextView detailsGarageName;
    private TextView detailsAddress;
    private TextView detailsTelNumber;
    private ContentFrameLayout detailsVoituresContainer;

    public GaragisteDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_garagiste_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.detailsFirstname = this.getView().findViewById(R.id.garagisteDetailsFirstname);
        this.detailsLastname = this.getView().findViewById(R.id.garagisteDetailsLastname);
        this.detailsAddress = this.getView().findViewById(R.id.garagisteDetailsAddress);
        this.detailsGarageName = this.getView().findViewById(R.id.garagisteDetailsGarageName);
        this.detailsTelNumber = this.getView().findViewById(R.id.garagisteDetailsTelNumber);
        this.detailsVoituresContainer = this.getView().findViewById(R.id.garagisteDetailsVoituresContainer);

        setupView();
        setupFragment();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void setupView() {
        if (this.garagiste != null) {
            this.detailsFirstname.setText(this.garagiste.getFirstname());
            this.detailsLastname.setText(this.garagiste.getLastname());
            this.detailsAddress.setText(this.garagiste.getAddress());
            this.detailsGarageName.setText(this.garagiste.getGarageName());
            this.detailsTelNumber.setText(this.garagiste.getTelNumber());
        }
    }

    private void setupFragment() {
        FragmentManager fragmentManager = this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        VoitureListFragment fragment = new VoitureListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FRAGMENT_ITEM,garagiste);
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentDetailsGaragisteContainer, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null && args.getSerializable(GaragisteDetailsActivity.FRAGMENT_ITEM)!=null){
            this.garagiste = (Garagiste) args.getSerializable(GaragisteDetailsActivity.FRAGMENT_ITEM);
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
