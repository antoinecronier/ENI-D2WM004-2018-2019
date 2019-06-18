package com.tactfactory.vroom.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tactfactory.vroom.R;
import com.tactfactory.vroom.entities.Garagiste;
import com.tactfactory.vroom.entities.Voiture;
import com.tactfactory.vroom.views.activities.MainActivity;
import com.tactfactory.vroom.views.activities.VoitureDetailsActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VoitureDetailsFragment extends Fragment {

    private Voiture voiture;
    private OnFragmentInteractionListener mListener;
    private TextView detailsPlaque;
    private TextView detailsMarque;
    private TextView detailsCouleur;
    private TextView detailsNom;
    private TextView detailsDateMiseEnCirculation;
    private LinearLayoutCompat detailsGaragiste;
    private TextView detailsGaragisteNomGarage;
    private TextView detailsGaragisteTelGarage;

    public VoitureDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_voiture_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.detailsPlaque = this.getView().findViewById(R.id.detailsPlaque);
        this.detailsMarque = this.getView().findViewById(R.id.detailsMarque);
        this.detailsCouleur = this.getView().findViewById(R.id.detailsCouleur);
        this.detailsNom = this.getView().findViewById(R.id.detailsNom);
        this.detailsDateMiseEnCirculation = this.getView().findViewById(R.id.detailsDateMiseEnCirculation);
        this.detailsGaragiste = this.getView().findViewById(R.id.detailsGaragiste);
        this.detailsGaragisteNomGarage = this.getView().findViewById(R.id.detailsGaragisteNomGarage);
        this.detailsGaragisteTelGarage = this.getView().findViewById(R.id.detailsGaragisteTelGarage);

        this.detailsGaragiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoitureDetailsFragment.this.mListener.onFragmentInteraction(VoitureDetailsFragment.this.voiture.getGaragiste());
            }
        });
        setupView();
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
        if (this.voiture != null) {
            this.detailsCouleur.setText(this.voiture.getCouleur());
            this.detailsMarque.setText(this.voiture.getMarque());

            LocalDate localDate = this.voiture.getDateDeMiseEnCirculation();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

            this.detailsDateMiseEnCirculation.setText(formatter.format(localDate));

            this.detailsNom.setText(this.voiture.getNom());
            this.detailsPlaque.setText(this.voiture.getPlaque());

            this.detailsGaragisteNomGarage.setText(this.voiture.getGaragiste().getGarageName());
            this.detailsGaragisteTelGarage.setText(this.voiture.getGaragiste().getTelNumber());
        }
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null && args.getSerializable(VoitureDetailsActivity.FRAGMENT_ITEM)!=null){
            this.voiture = (Voiture) args.getSerializable(VoitureDetailsActivity.FRAGMENT_ITEM);
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
        void onFragmentInteraction(Garagiste garagiste);
    }
}
