package fr.acos.androkado.views.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import fr.acos.androkado.R;
import fr.acos.androkado.database.DbManager;
import fr.acos.androkado.entities.Utilisateur;
import fr.acos.androkado.utils.ProgressableActivity;
import fr.acos.androkado.utils.UtilisateurStaticDatas;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class UtilisateurFragment extends Fragment {

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ProgressableActivity progressBarActivity = null;
    private RecyclerView recyclerView = null;
    private MyUtilisateurRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UtilisateurFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utilisateur_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            MyDividerItemDecoration dividerItemDecoration = new MyDividerItemDecoration(recyclerView.getContext(),
                    DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(dividerItemDecoration);

            adapter = new MyUtilisateurRecyclerViewAdapter(new ArrayList<Utilisateur>(), mListener);
            recyclerView.setAdapter(adapter);

            new UpdateRecycler().execute();
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

        if (context instanceof ProgressableActivity){
            this.progressBarActivity = ((ProgressableActivity) context);
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
        void onListFragmentInteraction(Utilisateur item);
    }

    public class MyDividerItemDecoration extends DividerItemDecoration{

        /**
         * Creates a divider {@link RecyclerView.ItemDecoration} that can be used with a
         * {@link LinearLayoutManager}.
         *
         * @param context     Current context, it will be used to access resources.
         * @param orientation Divider orientation. Should be {@link #HORIZONTAL} or {@link #VERTICAL}.
         */
        public MyDividerItemDecoration(Context context, int orientation) {
            super(context, orientation);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = 20;
            outRect.bottom = 20;
        }
    }

    public class UpdateRecycler extends AsyncTask<Void,Void,List<Utilisateur>>{


        @Override
        protected List<Utilisateur> doInBackground(Void... voids) {
            DbManager dbManager = new DbManager();

            List<Utilisateur> users = dbManager.getUserDAO()
                    .select(UtilisateurFragment.this.progressBarActivity);

            return users;
        }

        @Override
        protected void onPostExecute(List<Utilisateur> utilisateurs) {
            super.onPostExecute(utilisateurs);

            UtilisateurFragment.this.adapter.updateList(utilisateurs);
        }
    }
}
