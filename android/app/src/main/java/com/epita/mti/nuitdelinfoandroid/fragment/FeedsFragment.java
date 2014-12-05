package com.epita.mti.nuitdelinfoandroid.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.adapter.CampaignAdapter;
import com.epita.mti.nuitdelinfoandroid.adapter.FeedAdapter;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Feed;
import com.epita.mti.nuitdelinfoandroid.model.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yvan on 12/4/14.
 */
public class FeedsFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private FeedAdapter mAdapter;

    private Campaign mCampaign;

    public FeedsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            int campaignId = getArguments().getInt("campaign");
            mCampaign = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.feeds_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Feed> feeds = new ArrayList<>();

        User u = new User();
        u.setLogin("user");

        Feed f = new Feed();

        f.setUser(u);
        f.setMesssage("lorem ipsum dolor sit amet dnuez auief hirhutzioru uzorhi rh iuegr hiogrzhiougrzhiou");
        f.setSubmissionDate(new Date());

        feeds.add(f);

        mAdapter = new FeedAdapter(getActivity(), feeds, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        loadData();

        return view;
    }


    private void loadData() {

    }
}
