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
import com.epita.mti.nuitdelinfoandroid.controller.CampaignController;
import com.epita.mti.nuitdelinfoandroid.controller.CampaignsController;
import com.epita.mti.nuitdelinfoandroid.controller.ControllerCallback;
import com.epita.mti.nuitdelinfoandroid.controller.TinyTubeController;
import com.epita.mti.nuitdelinfoandroid.design.MenuDrawer;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Campaigns;
import com.epita.mti.nuitdelinfoandroid.model.Model;
import com.epita.mti.nuitdelinfoandroid.model.TinyTubeModel;
import com.epita.mti.nuitdelinfoandroid.model.TinyTubeModel.Item;
import com.epita.mti.nuitdelinfoandroid.request.JacksonRequest;
import com.epita.mti.nuitdelinfoandroid.util.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.mission_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        loadData();

        return view;
    }

    private void loadData() {
        CampaignsController controller = new CampaignsController();
        controller.getAll(new ControllerCallback() {
            @Override
            public void onResponse(Model response) {
                List<Campaign> campaigns = ((Campaigns)response).getCampaigns();
                mAdapter = new CampaignAdapter(getActivity(), campaigns, mRecyclerView);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Exception error) {
                Log.d(TAG, "Error : " + error);
            }
        });
    }
}
