package com.epita.mti.nuitdelinfoandroid.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.epita.mti.nuitdelinfoandroid.R;
import com.epita.mti.nuitdelinfoandroid.fragment.CampaignFragment;
import com.epita.mti.nuitdelinfoandroid.fragment.FeedsFragment;
import com.epita.mti.nuitdelinfoandroid.model.Campaign;

/**
 * Created by yvan on 12/4/14.
 */
public class FeedsActivity extends BaseActivity {
    private final String TAG = FeedsActivity.class.getSimpleName();
    private Campaign mCampaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_feeds);
        super.onCreate(savedInstanceState);

        int campaignId = getIntent().getExtras().getInt("campaign");
        mCampaign = null;

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, createFragment(campaignId))
                    .commit();
        }
    }

    private static FeedsFragment createFragment(int campaignId) {
        FeedsFragment fragment = new FeedsFragment();
        Bundle args = new Bundle();
        args.putInt("campaign", campaignId);
        fragment.setArguments(args);
        return fragment;
    }
}
