package com.epita.mti.nuitdelinfoandroid.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.adapter.FeedsArrayAdapter;
import com.epita.mti.nuitdelinfoandroid.design.PaletteTransformation;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;
import com.epita.mti.nuitdelinfoandroid.model.Feed;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * Created by yvan on 12/4/14.
 */
public class FeedsFragment extends Fragment {
    private Campaign mCampaign;

    public FeedsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int campaignId = getArguments().getInt("campaign");
        mCampaign = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        ListView listview =  (ListView)view.findViewById(R.id.feeds_listview);
        Feed[] feeds = new Feed[10];
        for (int i = 0 ; i < feeds.length; i++) {
            Feed feed = new Feed();
            feed.setMesssage("kehgksejglegeg");
            feed.setSubmissionDate(new Date());
            feeds[i] = feed;
        }
        FeedsArrayAdapter adapter = new FeedsArrayAdapter(getActivity(), feeds);
        listview.setAdapter(adapter);

        return view;
    }


    private void loadData() {

    }
}
