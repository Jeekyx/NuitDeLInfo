package com.epita.mti.nuitdelinfoandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.adapter.CampaignAdapter;
import com.epita.mti.nuitdelinfoandroid.controller.ControllerCallback;
import com.epita.mti.nuitdelinfoandroid.controller.TinyTubeController;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawer;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.TinyTubeModel;
import com.epita.mti.nuitdelinfoandroid.model.TinyTubeModel.Item;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequest;
import com.epita.mti.nuitdelinfoandroid.util.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Date;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private CampaignAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.mission_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Campaign> campaigns = new ArrayList<>();

        Campaign c = new Campaign();

        c.setName("Name");
        c.setLocation("Paris");
        c.setInscriptionEndDate(new Date());

        campaigns.add(c);

        mAdapter = new CampaignAdapter(campaigns, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        loadData();

        return view;
    }

    private void loadData() {

    }
}
